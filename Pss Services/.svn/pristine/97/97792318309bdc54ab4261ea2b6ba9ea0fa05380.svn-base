package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.FamilyDetailsRepo;
import gov.pssServices.pssServices.request.FamilyDetailsRequest;
import gov.pssServices.pssServices.service.FamilyDetailsService;
import org.json.JSONArray;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FamilyDetailsServiceImpl implements FamilyDetailsService {
    @Inject
    private FamilyDetailsRepo familyDetailsRepo;
    @Override
    public JSONArray familyDetails(FamilyDetailsRequest familyDetailsRequest) throws PssException {
        return familyDetailsRepo.famiyDetail(familyDetailsRequest);
    }
}
