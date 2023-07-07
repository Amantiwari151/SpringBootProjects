package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.FamilyDetailsRepo;
import gov.pssServices.pssServices.request.FamilyDetailsRequest;
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
public class FamilyDetailsRepoImpl implements FamilyDetailsRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public JSONArray famiyDetail(FamilyDetailsRequest familyDetailsRequest) throws PssException {
        JSONArray jsonArray = new JSONArray();
        try (Connection conn = this.testDataSource.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call PSN.sp_pss_familydetails(?,?,?,?)}")) {

            cstmt.setString(1, familyDetailsRequest.getSsoId());
            cstmt.setString(2, familyDetailsRequest.getPensionerId());
            cstmt.registerOutParameter(3, Types.CLOB);
            cstmt.registerOutParameter(4, Types.VARCHAR);
            cstmt.execute();
            String statusval = cstmt.getString(4);

            if (statusval.equalsIgnoreCase("SUCCESS")) {
                Clob clob = cstmt.getClob(3);
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
           throw new PssException("An error occurred while retrieving profile details.");
        }
        return jsonArray;
    }
}