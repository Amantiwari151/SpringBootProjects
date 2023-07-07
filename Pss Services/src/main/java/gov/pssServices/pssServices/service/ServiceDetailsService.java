package gov.pssServices.pssServices.service;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.response.ServiceDetailsResponse;

import java.util.List;

public interface ServiceDetailsService {
    List<ServiceDetailsResponse> getServiceDetails() throws PssException;
}
