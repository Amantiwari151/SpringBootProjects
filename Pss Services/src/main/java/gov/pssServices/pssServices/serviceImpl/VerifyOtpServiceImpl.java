package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.VerifyOtpRepo;
import gov.pssServices.pssServices.request.VerifyOtpRequest;
import gov.pssServices.pssServices.response.VerifyOtpResponse;
import gov.pssServices.pssServices.service.VerifyOtpService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class VerifyOtpServiceImpl implements VerifyOtpService {

    @Inject
    private VerifyOtpRepo verifyOtpRepo;

    @Override
    public List<VerifyOtpResponse>  getVerifyOtp(VerifyOtpRequest verifyOtpRequest) throws PssException {
        return verifyOtpRepo.getVerifyOtps(verifyOtpRequest);
    }
}
