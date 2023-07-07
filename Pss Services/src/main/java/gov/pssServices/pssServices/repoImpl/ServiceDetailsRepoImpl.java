package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.ServiceDetailsRepo;
import gov.pssServices.pssServices.response.ServiceDetailsResponse;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class ServiceDetailsRepoImpl implements ServiceDetailsRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public List<ServiceDetailsResponse> getAllServiceDetails() throws PssException {
        Connection connection = null;
        try{
            List<ServiceDetailsResponse> list =new ArrayList<>();
            connection = this.testDataSource.getConnection();
            String sql = "SELECT SERVICE_ID,SERVICE_NAME,QUALIFYING FROM LMDM.PSN_SERVICE_RECORD ORDER BY SERVICE_NAME";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ServiceDetailsResponse serviceDetailsResponse= new ServiceDetailsResponse();
                serviceDetailsResponse.setServiceId(Integer.parseInt(rs.getString("SERVICE_ID")));
                serviceDetailsResponse.setServiceName(rs.getString("SERVICE_NAME"));
                serviceDetailsResponse.setQualifying(rs.getString("QUALIFYING"));
                list.add(serviceDetailsResponse);
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
            return (List<ServiceDetailsResponse>)  new PssException("Error : Something went wrong");
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