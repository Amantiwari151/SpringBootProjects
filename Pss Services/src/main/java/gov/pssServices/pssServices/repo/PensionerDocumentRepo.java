package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.response.PensionerDocumentResponse;

public interface PensionerDocumentRepo {
    int pensionerDocument(PensionerDocumentResponse pensionerDocumentResponse) throws PssException;
}
