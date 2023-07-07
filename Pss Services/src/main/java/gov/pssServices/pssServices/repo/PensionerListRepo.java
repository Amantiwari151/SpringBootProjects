package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PensionerListRequest;
import gov.pssServices.pssServices.response.PensionerListResponse;
import java.util.List;

public interface PensionerListRepo {
    List<PensionerListResponse> getAllPensionerList(PensionerListRequest pensionerListRequest) throws PssException;
}
