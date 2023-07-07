package gov.pssServices.pssServices.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.json.JSONArray;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.BankAccountDetailsRequest;
import gov.pssServices.pssServices.service.BankAccountDetailsService;

@Path("pss")
public class BankAccountDetailsController {

	@Inject
	private BankAccountDetailsService bankAccountDetailsService;

	@Path("/getbankaccountdetails")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getBankAccountDetails(@RequestBody BankAccountDetailsRequest bankAccountDetailsReq) {
		try {
			JSONArray bankAccountDetails = bankAccountDetailsService
					.getBankAccountDetails(bankAccountDetailsReq);

			return Response.ok(ApiResponse.success(bankAccountDetails.toList())).build();
		} catch (PssException e) {
			e.getMessage();
			return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
		}
	}
}
