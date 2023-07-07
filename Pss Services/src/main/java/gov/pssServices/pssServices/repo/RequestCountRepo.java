package gov.pssServices.pssServices.repo;

import org.json.JSONArray;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.CountRequest;

public interface RequestCountRepo {

	JSONArray getRequestCount(CountRequest countReq) throws PssException;
	
}
