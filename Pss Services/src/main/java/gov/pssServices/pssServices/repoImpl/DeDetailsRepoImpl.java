package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.DeDetailsRepo;
import gov.pssServices.pssServices.request.DeDetailsRequest;
import gov.pssServices.pssServices.response.DeDetailsResponse;
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
public class DeDetailsRepoImpl implements DeDetailsRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public  List<DeDetailsResponse> getDeDetails(DeDetailsRequest deDetailsRequest) throws PssException {
        Connection connection = null;
        List<DeDetailsResponse> list = new ArrayList<>();
        try {
            connection = this.testDataSource.getConnection();
            String sql ="select DE_TYPE_ID,DE_START_DT,DE_END_DT,DE_REMARK,penalty_Type from PSN.PSN_DE_DTLS pd\n" +
                    "inner join  PSN.PSN_ppo ppo on ppo.PENSIONER_ID=pd.PENSIONER_ID\n" +
                    "where EMPLOYEE_CODE= ? order by pd.CREATED_DT asc\n" +
                    "FETCH FIRST 1 ROW ONLY";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, deDetailsRequest.getEmployeeCode());

            System.out.println("The Data............" + sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DeDetailsResponse deDetailsResponse = new DeDetailsResponse();
                deDetailsResponse.setDeTypeId(rs.getString("DE_TYPE_ID") != null ? rs.getString("DE_TYPE_ID") : "");
                if(rs.getString("DE_START_DT")!= null) {
                    Timestamp stamp = Timestamp.valueOf(rs.getString("DE_START_DT"));
                    java.util.Date d = new java.util.Date();
                    d.setTime(stamp.getTime());
                    String formattedDate = new SimpleDateFormat("dd-MM-YYYY").format(d);
                    deDetailsResponse.setDeStartDt(formattedDate);
                }else{
                    deDetailsResponse.setDeStartDt("");
                }
                if(rs.getString("DE_END_DT")!= null) {
                    Timestamp stamp = Timestamp.valueOf(rs.getString("DE_END_DT"));
                    java.util.Date d = new Date();
                    d.setTime(stamp.getTime());
                    String formattedDate = new SimpleDateFormat("dd-MM-YYYY").format(d);
                    deDetailsResponse.setDeEndDt(formattedDate);
                }else{
                    deDetailsResponse.setDeEndDt("");
                }
                deDetailsResponse.setDeRemark(rs.getString("DE_REMARK") != null ? rs.getString("DE_REMARK") : "");
                deDetailsResponse.setPenaltyType(rs.getString("penalty_Type") != null ? rs.getString("penalty_Type") : "");

                list.add(deDetailsResponse);
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
            return (List<DeDetailsResponse>) new PssException("Error : Something went wrong");
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
