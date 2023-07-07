package gov.pssServices.pssServices.service;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PendingListRequest;
import gov.pssServices.pssServices.request.PensionerListRequest;
import gov.pssServices.pssServices.response.PensionerListResponse;

import java.util.List;

public interface PensionerListService {
    List<PensionerListResponse> getPensionerList(PensionerListRequest pensionerListRequest) throws PssException;

}
