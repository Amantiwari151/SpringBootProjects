package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionTypeRepo;
import gov.pssServices.pssServices.response.PensionTypeResponse;
import gov.pssServices.pssServices.service.PensionTypeService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PensionTypeServiceImpl  implements PensionTypeService {
    @Inject
    private PensionTypeRepo  pensionTypeRepo;
    @Override
    public List<PensionTypeResponse> getPensionType() throws PssException {
        return pensionTypeRepo.getAllPensionType();
    }
}
