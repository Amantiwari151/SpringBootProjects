package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.ProfileDetailsRepo;
import gov.pssServices.pssServices.request.ProfileDetailsRequest;
import gov.pssServices.pssServices.service.ProfileDetailsService;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ProfileDetailsServiceImpl implements ProfileDetailsService {
    @Inject
    private ProfileDetailsRepo profileDetailsRepo;
    @Override
    public JSONObject ProfileDetails(ProfileDetailsRequest profileDetailsRequest) throws PssException {
        return profileDetailsRepo.ProfileDetails(profileDetailsRequest);
    }

    @Override
    public JSONArray ProfileDetailsDummy(ProfileDetailsRequest profileDetailsRequest) throws PssException {
        return profileDetailsRepo.ProfileDetailsDummy(profileDetailsRequest);
    }
}
