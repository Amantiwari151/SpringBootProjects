package gov.pssServices.pssServices.service;

import org.json.JSONArray;


import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.CountRequest;

public interface RequestCountService {
	
	JSONArray getRequestCount(CountRequest req) throws PssException;
	
}
