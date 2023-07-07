package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionerMarkRepo;
import gov.pssServices.pssServices.request.PensionerMarkRequest;
import gov.pssServices.pssServices.service.PensionerMarkService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PensionerMarkServiceImpl implements PensionerMarkService {
    @Inject
    private PensionerMarkRepo pensionerMarkRepo;
    @Override
    public    String getPensionerMark(PensionerMarkRequest pensionerMarkRequest) throws PssException {
        return pensionerMarkRepo.getPensionerMarks(pensionerMarkRequest);
    }
}
