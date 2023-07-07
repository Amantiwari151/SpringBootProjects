package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.NomineeDetailsRequest;
import gov.pssServices.pssServices.service.NomineeDetailsService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("pss")
public class NomineeDetailsController {
    @Inject
    private NomineeDetailsService nomineeDetailsService;

    @Path("/getnomineedetails")
    @POST
    public Response NomineeDetails(@RequestBody NomineeDetailsRequest nomineeDetailsRequest){

        try{
            String response = nomineeDetailsService.NomineeDetails(nomineeDetailsRequest);
            return Response.ok(ApiResponse.success(response)).build();
        } catch(PssException e){
            e.getMessage();

            return  Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }
    }
}

