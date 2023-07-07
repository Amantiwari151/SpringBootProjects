package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PpoDetailsRepo;
import gov.pssServices.pssServices.request.PpoDetailsRequest;
import gov.pssServices.pssServices.response.PpoDetailsResponse;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Dependent
public class PpoDetailsRepoImpl  implements PpoDetailsRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public  List<PpoDetailsResponse> getPpoDtls(@RequestBody PpoDetailsRequest ppoDetailsRequest) throws PssException {
        Connection connection = null;
        try{
            List<PpoDetailsResponse> list =new ArrayList<>();
            connection = this.testDataSource.getConnection();
            String sql = " select  pp.PPO_NO,cp.cpo_no,pp.PENSIONER_ID,pe.name_en,pp.EMPLOYEE_CODE,pp.PSN_AMT,pp.PPO_APRV_DATE,\n" +
                    "pp.FAMILY_PSN_AMT,pp.ENHANCE_PSN_AMT,pp.ENHANCE_PSN_START,pp.ENHANCE_PSN_END,cp.cmut_amt,\n" +
                    "cp.cmut_monthly_amt,cp.effective_cmut_dt,pp.PSN_TYPE_ID,pp.PSN_ZONE,pe.sso_id,pp.TREASURY_CODE,pp.IS_ACTIVE,\n" +
                    "ADD_MONTHS(cp.effective_cmut_dt, (12*14)) as cmut_end_dt,(pp.psn_amt-cp.cmut_monthly_amt) as final_psn_amt,\n" +
                    "((pp.psn_amt-cp.cmut_monthly_amt) * 12) as yearly_amt_aft_cmut_dedu,(pp.psn_amt * 12) as yearly_sal_wt_cmut,\n" +
                    "--(select count(CPO_NO) from psn_cpo where effective_cmut_dt <= sysdate and pensioner_id =pp.pensioner_id ) cpoCount\n" +
                    "(select trunc(months_between(sysdate,EFFECTIVE_CMUT_DT)) from PSN.psn_cpo pc   where pc.pensioner_id =pp.pensioner_id FETCH FIRST 1 ROW ONLY) as  cpoCount\n" +
                    " from PSN.psn_ppo  pp \n" +
                    " left join PSN.psn_cpo  cp on cp.pensioner_id=pp.pensioner_id \n" +
                    " left join PSN.psn_personal_dtls  pe on  pe.pensioner_id=pp.pensioner_id where pe.sso_id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ppoDetailsRequest.getSsoId());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                PpoDetailsResponse ppoDetailsResponse= new PpoDetailsResponse();
                ppoDetailsResponse.setPpoNo(rs.getString("PPO_NO"));
                ppoDetailsResponse.setCpoNo(rs.getString("cpo_no"));
                ppoDetailsResponse.setPensionerId(rs.getString("PENSIONER_ID"));
                ppoDetailsResponse.setNameEn(rs.getString("name_en"));
                ppoDetailsResponse.setEmployeeCode(rs.getString("EMPLOYEE_CODE"));
                ppoDetailsResponse.setPsnAmount(rs.getString("PSN_AMT"));
                ppoDetailsResponse.setFamilyPsnAmt(rs.getString("FAMILY_PSN_AMT"));
                ppoDetailsResponse.setEnhancePsnAmt(rs.getString("ENHANCE_PSN_AMT"));
                ppoDetailsResponse.setCmutAmt(rs.getString("cmut_amt"));
                ppoDetailsResponse.setCmutMonthlyAmt(rs.getString("cmut_monthly_amt"));
                ppoDetailsResponse.setPsnTypeId(rs.getString("PSN_TYPE_ID"));
                ppoDetailsResponse.setPsnZone(rs.getString("PSN_ZONE"));
                ppoDetailsResponse.setSsoId(rs.getString("sso_id"));
                ppoDetailsResponse.setTreasuryCode(rs.getString("TREASURY_CODE"));
                ppoDetailsResponse.setIsActive(rs.getString("IS_ACTIVE"));
                ppoDetailsResponse.setFinalPsnAmt(rs.getString("final_psn_amt"));
                ppoDetailsResponse.setYearlyAmtAftCmutDedu(rs.getString("yearly_amt_aft_cmut_dedu"));
                ppoDetailsResponse.setYearlySalWtCmut(rs.getString("yearly_sal_wt_cmut"));
                ppoDetailsResponse.setCpoCount(rs.getString("cpoCount"));
                if(rs.getString("cmut_end_dt")!= null) {
                    Timestamp stamp = Timestamp.valueOf(rs.getString("cmut_end_dt"));
                    java.util.Date d = new Date();
                    d.setTime(stamp.getTime());
                    String formattedDate = new SimpleDateFormat("dd-MM-YYYY").format(d);
                    ppoDetailsResponse.setCmutEndDt(formattedDate);
                }else{
                    ppoDetailsResponse.setCmutEndDt("");
                }
                if(rs.getString("effective_cmut_dt")!= null) {
                    Timestamp stamp = Timestamp.valueOf(rs.getString("effective_cmut_dt"));
                    java.util.Date d = new Date();
                    d.setTime(stamp.getTime());
                    String formattedDate = new SimpleDateFormat("dd-MM-YYYY").format(d);
                    ppoDetailsResponse.setEffectiveCmutDt(formattedDate);
                }else{
                    ppoDetailsResponse.setEffectiveCmutDt("");
                }
                if(rs.getString("ENHANCE_PSN_END")!= null) {
                    Timestamp stamp = Timestamp.valueOf(rs.getString("ENHANCE_PSN_END"));
                    java.util.Date d = new Date();
                    d.setTime(stamp.getTime());
                    String formattedDate = new SimpleDateFormat("dd-MM-YYYY").format(d);
                    ppoDetailsResponse.setEnhancePsnEnd(formattedDate);
                }else{
                    ppoDetailsResponse.setEnhancePsnEnd("");
                }
                if(rs.getString("ENHANCE_PSN_START")!= null) {
                    Timestamp stamp = Timestamp.valueOf(rs.getString("ENHANCE_PSN_START"));
                    java.util.Date d = new java.util.Date();
                    d.setTime(stamp.getTime());
                    String formattedDate = new SimpleDateFormat("dd-MM-YYYY").format(d);
                    ppoDetailsResponse.setEnhancePsnStart(formattedDate);
                }else{
                    ppoDetailsResponse.setEnhancePsnStart("");
                }
                if(rs.getString("PPO_APRV_DATE")!= null) {
                    Timestamp stamp = Timestamp.valueOf(rs.getString("PPO_APRV_DATE"));
                    java.util.Date d = new Date();
                    d.setTime(stamp.getTime());
                    String formattedDate = new SimpleDateFormat("dd-MM-YYYY").format(d);
                    ppoDetailsResponse.setPpoAprvDate(formattedDate);
                }else{
                    ppoDetailsResponse.setPpoAprvDate("");
                }

                list.add(ppoDetailsResponse);
            }
            rs.close();
            ps.close();
            return list;
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error - " + e.getMessage());
            return null;
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error - " + e.getMessage());
            return (List<PpoDetailsResponse>)  new PssException("Error : Something went wrong");
        } finally{
            try{
                if(!connection.isClosed()){
                    connection.close();
                }

            } catch(SQLException e){
                e.printStackTrace();
            }

        }
    }
}