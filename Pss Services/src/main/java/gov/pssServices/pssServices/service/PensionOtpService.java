package gov.pssServices.pssServices.service;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PensionOtpRequest;

import java.util.List;

public interface PensionOtpService {
    List<PensionOtpRequest> getPensionerOtp(PensionOtpRequest pensionOtpRequest) throws PssException;
}
