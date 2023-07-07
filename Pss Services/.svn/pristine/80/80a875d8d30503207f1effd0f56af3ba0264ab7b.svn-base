package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionerPersonalDetailsRepo;
import gov.pssServices.pssServices.request.PensionerPersonalDetailsRequest;
import gov.pssServices.pssServices.response.PensionerPersonalDetailsResponse;
import oracle.sql.TIMESTAMP;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Dependent
public class PensionerPersonalDetailsRepoImpl implements PensionerPersonalDetailsRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public List<PensionerPersonalDetailsResponse> getPensionerDetails(PensionerPersonalDetailsRequest pensionerPersonalDetailsRequest) throws PssException {
        Connection connection = null;
        List<PensionerPersonalDetailsResponse> list = new ArrayList<>();
        try {
            connection = this.testDataSource.getConnection();
            String sql ="select a.PENSIONER_ID,\n" +
                    "\n" +
                    "a.PSN_TYPE_ID,\n" +
                    "a.EMPLOYEE_ID,\n" +
                    "a.EMPLOYEE_CODE,\n" +
                    "a.PPO_NO,\n" +
                    "a.NAME_HI,\n" +
                    "a.NAME_EN,\n" +
                    "a.DOB,\n" +
                    "a.SSO_ID,\n" +
                    "b.DATE_VALUE as DOR ,\n" +
                    "c.DMS_DOC_ID as pensionkitid,\n" +
                    "c1.DMS_DOC_ID as photo\n" +
                    "from PSN.PSN_PERSONAL_DTLS a\n" +
                    "left join PSN.PSN_DATES b on a.PENSIONER_ID=b.PENSIONER_ID and DATE_TYPE_ID=2\n" +
                    "left join PSN.psn_doc c on c.pensioner_id=a.pensioner_id and c.doc_type_id=34\n" +
                    "left join PSN.psn_doc c1 on c1.pensioner_id=a.pensioner_id and c1.doc_type_id=32\n" +
                    "where a.SSO_ID = ? and c.DMS_DOC_ID is not null";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pensionerPersonalDetailsRequest.getSsoId());

            System.out.println("The Data............" + sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PensionerPersonalDetailsResponse pensionerPersonalDetailsResponse = new PensionerPersonalDetailsResponse();
                pensionerPersonalDetailsResponse.setPensionerId(Long.parseLong(rs.getString("PENSIONER_ID")));
                pensionerPersonalDetailsResponse.setEmployeeCode(rs.getString("EMPLOYEE_CODE")!= null ? rs.getString("EMPLOYEE_CODE") : "");
                pensionerPersonalDetailsResponse.setPsnTypeId(rs.getString("PSN_TYPE_ID")!= null ? rs.getString("PSN_TYPE_ID") : "");
                pensionerPersonalDetailsResponse.setNameEn(rs.getString("NAME_EN")!= null ? rs.getString("NAME_EN") : "");
                pensionerPersonalDetailsResponse.setEmployeeId(rs.getString("EMPLOYEE_ID")!= null ? rs.getString("EMPLOYEE_ID") : "");
                pensionerPersonalDetailsResponse.setPpoNo(rs.getString("PPO_NO")!= null ? rs.getString("PPO_NO") : "");
                pensionerPersonalDetailsResponse.setNameHi(rs.getString("NAME_HI")!= null ? rs.getString("NAME_HI") : "");
                pensionerPersonalDetailsResponse.setSsoId(rs.getString("SSO_ID")!= null ? rs.getString("SSO_ID") : "");
                pensionerPersonalDetailsResponse.setPensionKitId(rs.getString("pensionkitid")!= null ? rs.getString("pensionkitid") : "");
                pensionerPersonalDetailsResponse.setPhoto(rs.getString("photo")!= null ? rs.getString("photo") : "");

                if(rs.getString("DOR")!= null) {
                    Timestamp stamp = Timestamp.valueOf(rs.getString("DOR"));
                    java.util.Date d = new Date();
                    d.setTime(stamp.getTime());
                    String formattedDate = new SimpleDateFormat("dd-MM-YYYY").format(d);
                    pensionerPersonalDetailsResponse.setDor(formattedDate);
                }else{
                    pensionerPersonalDetailsResponse.setDor("");
                }
                if(rs.getString("DOB")!= null) {
                    Timestamp stamp = Timestamp.valueOf(rs.getString("DOB"));
                    java.util.Date d = new Date();
                    d.setTime(stamp.getTime());
                    String formattedDate = new SimpleDateFormat("dd-MM-YYYY").format(d);
                    pensionerPersonalDetailsResponse.setDob(formattedDate);
                }else{
                    pensionerPersonalDetailsResponse.setDob("");
                }
                list.add(pensionerPersonalDetailsResponse);
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
            return (List<PensionerPersonalDetailsResponse>) new PssException("Error : Something went wrong");
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