package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PensionerPersonalDetailsRequest;
import gov.pssServices.pssServices.response.PensionerPersonalDetailsResponse;

import java.util.List;

public interface PensionerPersonalDetailsRepo {
    List<PensionerPersonalDetailsResponse> getPensionerDetails(PensionerPersonalDetailsRequest pensionerPersonalDetailsRequest) throws PssException;
}
