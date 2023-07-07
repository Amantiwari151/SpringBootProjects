package gov.pssServices.pssServices.service;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.FamilyDetailsRequest;
import org.json.JSONArray;

public interface FamilyDetailsService {
    JSONArray familyDetails(FamilyDetailsRequest familyDetailsRequest) throws PssException;
}
