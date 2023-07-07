package gov.pssServices.pssServices.service;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PpoDetailsRequest;
import gov.pssServices.pssServices.response.PpoDetailsResponse;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;

public interface PpoDetailsService {
    List<PpoDetailsResponse> getPpoDtls(@RequestBody PpoDetailsRequest ppoDetailsRequest) throws PssException;
}
