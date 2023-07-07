package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.ProfileDetailsRequest;
import org.json.JSONArray;
import org.json.JSONObject;

public interface ProfileDetailsRepo {
    JSONObject ProfileDetails(ProfileDetailsRequest profileDetailsRequest) throws PssException;

    JSONArray ProfileDetailsDummy(ProfileDetailsRequest profileDetailsRequest) throws PssException;
}
