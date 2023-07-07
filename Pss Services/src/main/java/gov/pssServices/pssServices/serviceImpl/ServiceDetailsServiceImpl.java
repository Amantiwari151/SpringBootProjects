package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.ServiceDetailsRepo;
import gov.pssServices.pssServices.response.ServiceDetailsResponse;
import gov.pssServices.pssServices.service.ServiceDetailsService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ServiceDetailsServiceImpl implements ServiceDetailsService {
    @Inject
    private ServiceDetailsRepo serviceDetailsRepo;
    @Override
    public List<ServiceDetailsResponse> getServiceDetails() throws PssException {
        return serviceDetailsRepo.getAllServiceDetails();
    }
}
