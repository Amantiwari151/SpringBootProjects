package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.GetPensionerListForViewRepo;
import gov.pssServices.pssServices.request.GetPensionerListForViewRequest;
import gov.pssServices.pssServices.response.GetPensionerListForViewResponse;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class GetPensionerListForViewRepoImpl implements GetPensionerListForViewRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;

    @Override
    public List<GetPensionerListForViewResponse> getEmployeeDetails(GetPensionerListForViewRequest getPensionerListForViewRequest) throws PssException {
        Connection connection = null;
        List<GetPensionerListForViewResponse> list = new ArrayList<>();
        try {
            connection = this.testDataSource.getConnection();
            String sql ="SELECT DISTINCT\n" +
                    "    P.PENSIONER_ID,\n" +
                    "    P.EMPLOYEE_ID,\n" +
                    " P.EMPLOYEE_CODE,\n"+
                    "    P.NAME_EN AS PENSIONER_NAME,\n" +
                    "    P.SSO_ID,\n" +
                    "    P.PAN,\n" +
                    "    P.MOB_NO,\n" +
                    "    P.RELIGION_ID,\n" +
                    "    P.DOB,\n" +
                    "    P.EMAIL,\n" +
                    "    C.GPO_NO,\n" +
                    "    A.PPO_NO,\n" +
                    "    B.CPO_NO,\n" +
                    "    D.ASSIGNMENT_VALUE\n" +
                    "FROM\n" +
                    "    PSN.PSN_PERSONAL_DTLS P\n" +
                    "    LEFT JOIN  PSN.PSN_PPO A ON P.PENSIONER_ID = A.PENSIONER_ID\n" +
                    "    LEFT JOIN  PSN.PSN_CPO B ON A.PENSIONER_ID = B.PENSIONER_ID\n" +
                    "    INNER JOIN  PSN.PSN_GPO C ON A.PENSIONER_ID = C.PENSIONER_ID\n" +
                    "    LEFT JOIN sso.DTL_USER_ASSIGNMENT D ON D.USER_ASSIGNMENT_DTLS_ID=P.CREATED_BY_A_ID\n" +
                    "    LEFT JOIN mdm.mst_office ofc ON ofc.office_id= D.ASSIGNMENT_VALUE \n" +
                    "    where ofc.office_id= ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, getPensionerListForViewRequest.getOfficeId());

            System.out.println("The Data............" + sql);
            ResultSet rs = ps.executeQuery();
         
            	 while (rs.next()) {
                     GetPensionerListForViewResponse getPensionerListForViewResponse = new GetPensionerListForViewResponse();
                     getPensionerListForViewResponse.setPensionerId(rs.getString("PENSIONER_ID"));
                     getPensionerListForViewResponse.setEmployeeId(rs.getString("EMPLOYEE_ID"));
                     getPensionerListForViewResponse.setPensionerName((getStringValue(rs,"PENSIONER_NAME")));
                     getPensionerListForViewResponse.setSsoId(getStringValue(rs,"SSO_ID"));
                     getPensionerListForViewResponse.setPan(getStringValue(rs,"PAN"));
                     getPensionerListForViewResponse.setMobileNo(getStringValue(rs,"MOB_NO"));
                     getPensionerListForViewResponse.setReligionId(getStringValue(rs,"RELIGION_ID"));
                     getPensionerListForViewResponse.setDob(getStringValue(rs,"DOB"));
                     getPensionerListForViewResponse.setEmail(getStringValue(rs,"EMAIL"));
                     getPensionerListForViewResponse.setGpoNo(getStringValue(rs,"GPO_NO"));
                     getPensionerListForViewResponse.setPpoNo(getStringValue(rs,"PPO_NO"));
                     getPensionerListForViewResponse.setCpoNo(getStringValue(rs,"CPO_NO"));
                     getPensionerListForViewResponse.setAssignmentValue(getStringValue(rs,"ASSIGNMENT_VALUE"));
                     getPensionerListForViewResponse.setEmployeeCode(getStringValue(rs, "EMPLOYEE_CODE"));
                     list.add(getPensionerListForViewResponse);
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
            return (List<GetPensionerListForViewResponse>)  new PssException("Error : Something went wrong");
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
    private String getStringValue(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return (value != null) ? value : "";
    }
}