package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.ProfileDetailsRepo;
import gov.pssServices.pssServices.request.ProfileDetailsRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Types;

@Dependent
public class ProfileDetailsRepoImpl implements ProfileDetailsRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public JSONObject ProfileDetails(ProfileDetailsRequest profileDetailsRequest) throws PssException {

        JSONObject response = new JSONObject();

        try(Connection conn = this.testDataSource.getConnection();
            CallableStatement cstmt=conn.prepareCall("{call PSN.sp_pss_profiledetails(?,?,?,?)}"))
        {

            cstmt.setString(1, profileDetailsRequest.getSsoId());
            cstmt.setString(2,profileDetailsRequest.getPensionerId());
            cstmt.registerOutParameter(3, Types.CLOB);
            cstmt.registerOutParameter(4, Types.VARCHAR);
            cstmt.execute();
            String statusval = cstmt.getString(4);

            if (statusval.equalsIgnoreCase("SUCCESS")) {
                Clob clob = (Clob) cstmt.getObject(3);
                    if(clob == null || clob.length() == 0) {
                        String data = clob.getSubString(1, (int) clob.length());
                        response.put("msg","No data available");
                    } else {
                        String data = clob.getSubString(1, (int) clob.length());
//                        JSONObject jsonObject = new JSONObject("record",data);
                        response.put("data",data);
                    }
                } else {

                    response.put("msg","Error Occured.");
                }


        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public JSONArray ProfileDetailsDummy(ProfileDetailsRequest profileDetailsRequest) throws PssException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.testDataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call PSN.sp_pss_profiledetails(?,?,?,?)}")) {

            cstmt.setString(1, profileDetailsRequest.getSsoId());
            cstmt.setString(2, profileDetailsRequest.getPensionerId());
            cstmt.registerOutParameter(3, Types.CLOB);
            cstmt.registerOutParameter(4, Types.VARCHAR);
            cstmt.execute();
            String statusval = cstmt.getString(4);

            if (statusval.equalsIgnoreCase("SUCCESS")) {
                Clob clob = (Clob)cstmt.getClob(3);
                if (clob == null) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("msg", "no data available");
                    jsonArray.put(jsonObject);
                } else {
                    String data = clob.getSubString(1,(int)clob.length());
                    jsonArray = new JSONArray(data);
                }
            } else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("msg", "Error-Occurred");
                jsonArray.put(jsonObject);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // You should handle the exception appropriately, e.g., throw a custom exception or log the error.
            throw new PssException("An error occurred while retrieving profile details.");
        }

        return jsonArray;
    }




}