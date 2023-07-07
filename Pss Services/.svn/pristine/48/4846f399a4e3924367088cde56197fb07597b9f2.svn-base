package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PendingListRepo;
import gov.pssServices.pssServices.request.PendingListRequest;
import gov.pssServices.pssServices.service.PendingListService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PendingListServiceImpl implements PendingListService {
    @Inject
    private PendingListRepo pendingListRepo;
    @Override
    public String getPendingList(PendingListRequest pendingListRequest) throws PssException {
        return pendingListRepo.getPendingList(pendingListRequest);
    }
}
