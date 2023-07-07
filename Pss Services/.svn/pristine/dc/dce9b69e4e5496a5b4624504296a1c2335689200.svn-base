package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PpoDetailsRequest;
import gov.pssServices.pssServices.response.PpoDetailsResponse;
import gov.pssServices.pssServices.service.PpoDetailsService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pss/")
public class PpoDetailsController {
    @Inject
    private PpoDetailsService ppoDetailsService;
    @Path("/getppodetails")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response getPpoDetails(@RequestBody PpoDetailsRequest ppoDetailsRequest){
        try{
            List<PpoDetailsResponse> response = ppoDetailsService.getPpoDtls(ppoDetailsRequest);
            return Response.ok(ApiResponse.success(response)).build();
        } catch(PssException e){
            e.getMessage();
            return  Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }

    }
}



