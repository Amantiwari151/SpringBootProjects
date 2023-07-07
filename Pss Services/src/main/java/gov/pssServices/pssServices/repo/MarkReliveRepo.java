package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.response.MarkReliveResponse;

import java.util.List;

public interface MarkReliveRepo {
    String updatePersonalDetailsAll(MarkReliveResponse updatePersonalDetailsRequest) throws PssException;
}
