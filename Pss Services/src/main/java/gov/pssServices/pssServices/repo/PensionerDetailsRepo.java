package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PensionerDetailsRequest;
import gov.pssServices.pssServices.response.PensionerDetailsResponse;

import java.util.List;

public interface PensionerDetailsRepo {
    List<PensionerDetailsResponse> getPensionerDetailsAll(PensionerDetailsRequest pensionerDetailsRequest) throws PssException;
}
