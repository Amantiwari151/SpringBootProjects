package gov.pssServices.pssServices.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import com.google.gson.JsonArray;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.CountRequest;
import gov.pssServices.pssServices.service.RequestCountService;

@Path("pss/")
public class RequestCountController {

	@Inject
	private RequestCountService requestCount;
	
	 @Path("/getRequestCount")
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	public Response getCountRequest(CountRequest req) {
		
		try {
			JSONArray countData = requestCount.getRequestCount(req);
			
			return Response.ok(ApiResponse.success(countData.toList())).build();
			
		} catch (PssException e) {
			e.printStackTrace();
			
			return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
		}
		
	}
	
}
