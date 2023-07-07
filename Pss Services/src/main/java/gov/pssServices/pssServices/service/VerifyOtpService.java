package gov.pssServices.pssServices.service;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.VerifyOtpRequest;
import gov.pssServices.pssServices.response.VerifyOtpResponse;

import java.util.List;


public interface VerifyOtpService {
    List<VerifyOtpResponse> getVerifyOtp(VerifyOtpRequest verifyOtpRequest) throws PssException;
}
