package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionOtpRepo;
import gov.pssServices.pssServices.request.PensionOtpRequest;
import gov.pssServices.pssServices.service.PensionOtpService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PensionOtpServiceImpl implements PensionOtpService {
    @Inject
    private PensionOtpRepo pensionOtpRepo;

    @Override
    public List<PensionOtpRequest> getPensionerOtp(PensionOtpRequest pensionOtpRequest) throws PssException {
        return pensionOtpRepo.getPensionerOtpAll(pensionOtpRequest);
    }
}
