package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionTypeRepo;
import gov.pssServices.pssServices.response.PensionTypeResponse;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class PensionTypeRepoImpl implements PensionTypeRepo  {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public List<PensionTypeResponse> getAllPensionType() throws PssException {
        Connection connection = null;
        try{
            List<PensionTypeResponse> list =new ArrayList<>();
            connection = this.testDataSource.getConnection();
            String sql = "select PENSION_CODE, PENSION_TYPE from LMDM.MST_PSN_TYPE ORDER BY PENSION_CODE ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                PensionTypeResponse pensionTypeResponse= new PensionTypeResponse();
                pensionTypeResponse.setPensionCode(Integer.parseInt(rs.getString("PENSION_CODE")));
                pensionTypeResponse.setPensionType(rs.getString("PENSION_TYPE"));
                list.add(pensionTypeResponse);
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
            return (List<PensionTypeResponse>)  new PssException("Error : Something went wrong");
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
