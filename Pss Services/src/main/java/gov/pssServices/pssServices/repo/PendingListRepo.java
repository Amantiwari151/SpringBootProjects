package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PendingListRequest;

public interface PendingListRepo {
    String getPendingList(PendingListRequest pendingListRequest) throws PssException;
}
