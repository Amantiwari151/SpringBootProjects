package gov.pssServices.pssServices.service;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PensionerMarkRequest;


public interface PensionerMarkService {
    String getPensionerMark(PensionerMarkRequest pensionerMarkRequest) throws PssException;
}
