package gov.pssServices.pssServices.service;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.response.PensionTypeResponse;
import java.util.List;

public interface PensionTypeService {
    List<PensionTypeResponse> getPensionType() throws PssException;
}
