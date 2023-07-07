package gov.pssServices.pssServices.repo;

import org.json.JSONArray;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.BankAccountDetailsRequest;

public interface BankAccountDetailsRepo {
	
	JSONArray getBankAccountDetails(BankAccountDetailsRequest bankAccountDetailsRequest) throws PssException;
	
}
