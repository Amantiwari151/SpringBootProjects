package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.DeDetailsRequest;
import gov.pssServices.pssServices.response.DeDetailsResponse;
import gov.pssServices.pssServices.service.DeDetailsService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pss/")
public class DeDetailsController {
    @Inject
    private DeDetailsService deDetailsService;
    @Path("/getdedetails")
    @POST
    public Response getDeDetails(@RequestBody DeDetailsRequest deDetailsRequest){
        try{
            List<DeDetailsResponse> pdc= deDetailsService.getDeDetails(deDetailsRequest);
            return Response.ok(ApiResponse.success(pdc)).build();
        } catch(PssException e){
            e.getMessage();
            return  Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }

    }
}

