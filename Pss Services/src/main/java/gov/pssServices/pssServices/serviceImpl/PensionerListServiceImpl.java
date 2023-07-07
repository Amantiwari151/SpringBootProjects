package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionerListRepo;
import gov.pssServices.pssServices.request.PensionerListRequest;
import gov.pssServices.pssServices.response.PensionerListResponse;
import gov.pssServices.pssServices.service.PensionerListService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PensionerListServiceImpl implements PensionerListService {
	
    @Inject
    private PensionerListRepo pensionerListRepo;
    
    @Override
    public List<PensionerListResponse> getPensionerList(PensionerListRequest pensionerListRequest) throws PssException {
        return pensionerListRepo.getAllPensionerList(pensionerListRequest);
    }
}
