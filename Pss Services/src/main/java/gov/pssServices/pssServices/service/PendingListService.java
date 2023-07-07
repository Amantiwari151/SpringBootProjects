package gov.pssServices.pssServices.service;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PendingListRequest;
public interface PendingListService {
    String getPendingList(PendingListRequest pendingListRequest) throws PssException;
}
