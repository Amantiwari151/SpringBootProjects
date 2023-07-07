package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PensionerMarkRequest;


public interface PensionerMarkRepo {
    String getPensionerMarks(PensionerMarkRequest pensionerMarkRequest) throws PssException;
}
