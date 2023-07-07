package gov.pssServices.pssServices.repoImpl;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Types;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonObject;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.BankAccountDetailsRepo;
import gov.pssServices.pssServices.request.BankAccountDetailsRequest;

@Dependent
public class BankAccountDetailsRepoImpl implements BankAccountDetailsRepo {

	@Inject
	@Named("PSN_RW")
	private DataSource ds;

	@Override
	public JSONArray getBankAccountDetails(BankAccountDetailsRequest bankAccountDetailsRequest) throws PssException {

		JSONArray jsonArray = null;
		String response = "";
		try (Connection con = ds.getConnection();
		     CallableStatement cstmt = con.prepareCall("{call PSN.SP_PSS_GetBankAccDtls(?,?,?)}");) {
		    cstmt.setString(1, bankAccountDetailsRequest.getPsnId());
		    cstmt.setString(2, bankAccountDetailsRequest.getSsoId());
		    cstmt.registerOutParameter(3, Types.CLOB);

		    cstmt.execute();

		    Clob clob = (Clob) cstmt.getObject(3);

		    if (clob == null ) {
		    	jsonArray = new JSONArray();
		    	JSONObject jsonObject = new JSONObject();
		    	jsonObject.put("msg","No data Found");
                jsonArray.put(jsonObject);
                System.out.println(jsonArray);
		    } else {
		    	String data = clob.getSubString(1,(int)clob.length());
		    	jsonArray = new JSONArray();
		    	jsonArray.put(new JSONObject(data));
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return jsonArray;

	}
}
