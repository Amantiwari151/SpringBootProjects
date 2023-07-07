package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionerDetailsRepo;
import gov.pssServices.pssServices.request.PensionerDetailsRequest;
import gov.pssServices.pssServices.response.PensionerDetailsResponse;
import gov.pssServices.pssServices.service.PensionerDetailsService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PensionerDetailsServiceImpl  implements PensionerDetailsService {
    @Inject
    private PensionerDetailsRepo pensionerDetailsRepo;
    @Override
    public List<PensionerDetailsResponse> getPensionerDetails(PensionerDetailsRequest pensionerDetailsRequest) throws PssException {
        return pensionerDetailsRepo.getPensionerDetailsAll(pensionerDetailsRequest);
    }
}
