package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionerPersonalDetailsRepo;
import gov.pssServices.pssServices.request.PensionerPersonalDetailsRequest;
import gov.pssServices.pssServices.response.PensionerPersonalDetailsResponse;
import gov.pssServices.pssServices.service.PensionerPersonalDetailsService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PensionerPersonalDetailsServiceImpl implements PensionerPersonalDetailsService {
    @Inject
    private PensionerPersonalDetailsRepo pensionerPersonalDetailsRepo;
    @Override
    public List<PensionerPersonalDetailsResponse> getPensionerDetails(PensionerPersonalDetailsRequest pensionerPersonalDetailsRequest) throws PssException {
        return pensionerPersonalDetailsRepo.getPensionerDetails(pensionerPersonalDetailsRequest);
    }
}
