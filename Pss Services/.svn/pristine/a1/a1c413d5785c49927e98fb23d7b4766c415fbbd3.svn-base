package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PensionerDetailsRequest;
import gov.pssServices.pssServices.response.PensionerDetailsResponse;
import gov.pssServices.pssServices.service.PensionerDetailsService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pss/")
public class PensionerDetailsController {
    @Inject
    private PensionerDetailsService pensionerDetailsService;
    @Path("getpensionerdetails")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response getPensionerDetails(@Valid @RequestBody  PensionerDetailsRequest pensionerDetailsRequest){
        try{
            List<PensionerDetailsResponse> pdc= pensionerDetailsService.getPensionerDetails(pensionerDetailsRequest);
            return Response.ok(ApiResponse.success(pdc)).build();
        } catch(PssException e){
            e.getMessage();
            return Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }

    }
}

