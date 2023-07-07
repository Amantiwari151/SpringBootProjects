package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PpoDetailsRepo;
import gov.pssServices.pssServices.request.PpoDetailsRequest;
import gov.pssServices.pssServices.response.PpoDetailsResponse;
import gov.pssServices.pssServices.response.ServiceDetailsResponse;
import gov.pssServices.pssServices.service.PpoDetailsService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PpoDetailsServiceImpl  implements PpoDetailsService {
    @Inject
    private PpoDetailsRepo ppoDetailsRepo;
    @Override
    public List<PpoDetailsResponse> getPpoDtls(@RequestBody PpoDetailsRequest ppoDetailsRequest) throws PssException {
        return ppoDetailsRepo.getPpoDtls(ppoDetailsRequest);
    }
}
