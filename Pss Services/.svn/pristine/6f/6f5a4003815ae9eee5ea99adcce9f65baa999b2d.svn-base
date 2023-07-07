package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.response.PensionTypeResponse;
import gov.pssServices.pssServices.service.PensionTypeService;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pss/")
public class PensionTypeController {
    @Inject
    private PensionTypeService pensionTypeService;

    @Path("/getpensiontype")
    @POST
    public Response getAllPensionType(){
        try{
            List<PensionTypeResponse> states= pensionTypeService.getPensionType();
            return Response.ok(ApiResponse.success(states)).build();
        } catch(PssException e){
            e.getMessage();
            return  Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }
    }
}

