package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PpoDetailsRequest;
import gov.pssServices.pssServices.response.PpoDetailsResponse;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;

public interface PpoDetailsRepo {
    List<PpoDetailsResponse> getPpoDtls(@RequestBody PpoDetailsRequest ppoDetailsRequest) throws PssException;
}
