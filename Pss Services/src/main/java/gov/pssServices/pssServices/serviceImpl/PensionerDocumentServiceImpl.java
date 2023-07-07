package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionerDocumentRepo;
import gov.pssServices.pssServices.response.PensionerDocumentResponse;
import gov.pssServices.pssServices.service.PensionerDocumentService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@ApplicationScoped
public class PensionerDocumentServiceImpl implements PensionerDocumentService {
    @Inject
    private PensionerDocumentRepo pensionerDocumentRepo;
    @Override
    public int pensionerDocument(PensionerDocumentResponse pensionerDocumentResponse) throws PssException {
        return pensionerDocumentRepo.pensionerDocument(pensionerDocumentResponse);
    }
}
