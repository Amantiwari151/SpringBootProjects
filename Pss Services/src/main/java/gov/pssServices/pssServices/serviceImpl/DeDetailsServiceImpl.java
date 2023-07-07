package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.DeDetailsRepo;
import gov.pssServices.pssServices.request.DeDetailsRequest;
import gov.pssServices.pssServices.response.DeDetailsResponse;
import gov.pssServices.pssServices.service.DeDetailsService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class DeDetailsServiceImpl implements DeDetailsService {
    @Inject
    private DeDetailsRepo deDetailsRepo;
    @Override
    public List<DeDetailsResponse> getDeDetails(DeDetailsRequest deDetailsRequest) throws PssException {
        return deDetailsRepo.getDeDetails(deDetailsRequest);
    }
}
