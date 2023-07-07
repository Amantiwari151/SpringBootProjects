package gov.pssServices.pssServices.serviceImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.json.JSONArray;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.RequestCountRepo;
import gov.pssServices.pssServices.request.CountRequest;
import gov.pssServices.pssServices.service.RequestCountService;

@ApplicationScoped
public class RequestCountServiceImpl implements RequestCountService{
	
	@Inject
	private RequestCountRepo requestCountRepo;
	
	
	@Override
	public JSONArray getRequestCount(CountRequest req) throws PssException {
		return requestCountRepo.getRequestCount(req);
	}

}
