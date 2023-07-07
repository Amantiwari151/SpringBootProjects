package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.FamilyDetailsRequest;
import org.json.JSONArray;


public interface FamilyDetailsRepo {
    JSONArray famiyDetail(FamilyDetailsRequest familyDetailsRequest) throws PssException;
}
