package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.NomineeDetailsRepo;
import gov.pssServices.pssServices.request.NomineeDetailsRequest;
import gov.pssServices.pssServices.service.NomineeDetailsService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class NomineeDetailsServiceImpl implements NomineeDetailsService {
    @Inject
    private NomineeDetailsRepo nomineeDetailsRepo;

    @Override
    public String NomineeDetails(NomineeDetailsRequest nomineeDetailsRequest) throws PssException {
        return nomineeDetailsRepo.getNomineeDetails(nomineeDetailsRequest);
    }
}
