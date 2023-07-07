package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.response.ServiceDetailsResponse;
import gov.pssServices.pssServices.service.ServiceDetailsService;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pss/")
public class ServiceDetailsController {
    @Inject
    private ServiceDetailsService serviceDetailsService;

    @Path("/getservicedetails")
    @POST
    public Response getAllServiceDetails(){
        try{
            List<ServiceDetailsResponse> states= serviceDetailsService.getServiceDetails();
            return Response.ok(ApiResponse.success(states)).build();
        } catch(PssException e){
            e.getMessage();
            return  Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }
    }
}
