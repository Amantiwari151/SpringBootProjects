package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PensionerPersonalDetailsRequest;
import gov.pssServices.pssServices.response.PensionerPersonalDetailsResponse;
import gov.pssServices.pssServices.service.PensionerPersonalDetailsService;
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
public class PensionerPersonalDetailsController {
    @Inject
    private PensionerPersonalDetailsService pensionerPersonalDetailsService;

    @Path("getpensionerpersonaldetails")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response getPensionerDetails(@RequestBody PensionerPersonalDetailsRequest pensionerPersonalDetailsRequest){
        try{
            List<PensionerPersonalDetailsResponse> pdc= pensionerPersonalDetailsService.getPensionerDetails(pensionerPersonalDetailsRequest);

            return Response.ok(ApiResponse.success(pdc)).build();
        } catch(PssException e){
            e.getMessage();
            return Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }
    }
}

