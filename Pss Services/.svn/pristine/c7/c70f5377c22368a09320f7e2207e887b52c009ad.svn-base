package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionerDetailsRepo;
import gov.pssServices.pssServices.request.PensionerDetailsRequest;
import gov.pssServices.pssServices.response.PensionerDetailsResponse;
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
public class PensionerDetailsRepoImpl  implements PensionerDetailsRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public List<PensionerDetailsResponse> getPensionerDetailsAll(PensionerDetailsRequest pensionerDetailsRequest) throws PssException {
        Connection connection = null;
        List<PensionerDetailsResponse> list = new ArrayList<>();
        try {
            connection = this.testDataSource.getConnection();
            String sql ="select distinct psndtl.PENSIONER_ID,psndtl.Employee_code,Name_en,DOB,PAN,EMAIL,Mob_No,DESG_NAME_En,DEPT_NAME_EN \n" +
                    ",DOR \n" +
                    "from  PSN.PSN_PERSONAL_DTLS psndtl\n" +
                    "inner join  PSN.PSN_PPO ppo on ppo.PENSIONER_ID =psndtl.PENSIONER_ID\n" +
                    "inner join  PSN.PSN_SERVICE_DTLS psd on psd.PENSIONER_ID=psndtl.PENSIONER_ID\n" +
                    "inner join mdm.MST_DEPARTMENT dpt on dpt.DEPT_ID = psd.DEPT_ID\n" +
                    "where ppo.ppo_no=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pensionerDetailsRequest.getPpoNo());
            System.out.println("The Data............" + sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PensionerDetailsResponse pensionerDetailsResponse = new PensionerDetailsResponse();
                pensionerDetailsResponse.setPensionerId(Long.parseLong(rs.getString("PENSIONER_ID")));
                pensionerDetailsResponse.setEmployeeCode(rs.getString("Employee_code"));
                pensionerDetailsResponse.setNameEn(rs.getString("Name_en"));
                pensionerDetailsResponse.setPan(rs.getString("PAN"));
                pensionerDetailsResponse.setEmail(rs.getString("EMAIL"));
                pensionerDetailsResponse.setMobNo(Long.parseLong(rs.getString("Mob_No")));
                pensionerDetailsResponse.setDesgNameEn(rs.getString("DESG_NAME_En"));
                pensionerDetailsResponse.setDeptNameEn(rs.getString("DEPT_NAME_EN"));
                if(rs.getString("DOR")!= null) {
                    Timestamp stamp = Timestamp.valueOf(rs.getString("DOR"));
                    java.util.Date d = new Date();
                    d.setTime(stamp.getTime());
                    String formattedDate = new SimpleDateFormat("dd-MM-YYYY").format(d);
                    pensionerDetailsResponse.setDor(formattedDate);
                }else{
                    pensionerDetailsResponse.setDor("");
                }
                if(rs.getString("DOB")!= null) {
                    Timestamp stamp = Timestamp.valueOf(rs.getString("DOB"));
                    java.util.Date d = new Date();
                    d.setTime(stamp.getTime());
                    String formattedDate = new SimpleDateFormat("dd-MM-YYYY").format(d);
                    pensionerDetailsResponse.setDob(formattedDate);
                }else{
                    pensionerDetailsResponse.setDob("");
                }
                list.add(pensionerDetailsResponse);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - " + e.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error - " + e.getMessage());
            return (List<PensionerDetailsResponse>) new PssException("Error : Something went wrong");
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }
    }
}
