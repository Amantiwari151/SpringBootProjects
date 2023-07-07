package gov.pssServices.pssServices.repoImpl;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.RequestCountRepo;
import gov.pssServices.pssServices.request.CountRequest;

@Dependent
public class RequestCountRepoImpl implements RequestCountRepo {

	@Inject
	@Named("PSN_RW")
	private DataSource ds;

	@Override
	public JSONArray getRequestCount(CountRequest countReq) throws PssException {
		JSONArray jsonArray = new JSONArray();
		try (Connection con = ds.getConnection();
				CallableStatement cstmt = con.prepareCall("{ call PSN.sp_pss_request(?,?,?,?) }")) {
			
			cstmt.setString(1, countReq.getPensionerId());
			cstmt.setString(2, countReq.getSsoId());
			cstmt.registerOutParameter(3, Types.VARCHAR);
			 cstmt.registerOutParameter(4, Types.CLOB);
	            
			cstmt.execute();
			
			 String statusval = cstmt.getString(3);
			
			 if(statusval.equalsIgnoreCase("SUCCESS")) {
				 
				 Clob clob = (Clob)cstmt.getClob(4);
				 if(clob == null) {
					 JSONObject jsonObject = new JSONObject();
	                  jsonObject.put("msg", "no data available");
	                  jsonArray.put(jsonObject);
				 }
				 else {
					  String data = clob.getSubString(1,(int)clob.length());
	                  jsonArray = new JSONArray(data);
				 }
		 } else {
             JSONObject jsonObject = new JSONObject();
             jsonObject.put("msg", "Error-Occurred");
             jsonArray.put(jsonObject);
         }
			 
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PssException("An error occurred while retrieving profile details.");
		}

		return jsonArray;
	}

}
