package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.NomineeDetailsRequest;

public interface NomineeDetailsRepo {
    String getNomineeDetails(NomineeDetailsRequest nomineeDetailsRequest) throws PssException;
}
