package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.GetPensionerListForViewRepo;
import gov.pssServices.pssServices.request.GetPensionerListForViewRequest;
import gov.pssServices.pssServices.response.GetPensionerListForViewResponse;
import gov.pssServices.pssServices.service.GetPensionerListForViewService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
@ApplicationScoped
public class GetPensionerListForViewServiceImpl implements GetPensionerListForViewService {
    @Inject
    GetPensionerListForViewRepo getPensionerListForViewRepo;
    @Override
    public List<GetPensionerListForViewResponse> getEmployeeDetails(GetPensionerListForViewRequest getPensionerListForViewRequest) throws PssException {
        return getPensionerListForViewRepo.getEmployeeDetails(getPensionerListForViewRequest);
    }
}
