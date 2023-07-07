package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PensionerMarkRequest;
import gov.pssServices.pssServices.service.PensionerMarkService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pss/")
public class PensionerMarkController {
    @Inject
    private PensionerMarkService pensionerMarkService;
    @Path("savepensionermark")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response getPensionerMark(@RequestBody PensionerMarkRequest pensionerMarkRequest){
        try{
            String pdc= pensionerMarkService.getPensionerMark(pensionerMarkRequest);

            return Response.ok(ApiResponse.success(pdc)).build();
        } catch(PssException e){
            e.getMessage();
            return Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }
    }
}

