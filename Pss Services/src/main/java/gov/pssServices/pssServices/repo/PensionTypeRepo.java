package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.response.PensionTypeResponse;

import java.util.List;

public interface PensionTypeRepo {
    List<PensionTypeResponse> getAllPensionType() throws PssException;
}
