package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.GetPensionerListForViewRequest;
import gov.pssServices.pssServices.response.GetPensionerListForViewResponse;

import java.util.List;

public interface GetPensionerListForViewRepo {
    List<GetPensionerListForViewResponse> getEmployeeDetails(GetPensionerListForViewRequest getPensionerListForViewRequest) throws PssException;
}
