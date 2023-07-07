package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.AbsentProcessRoleRequest;
import gov.pssServices.pssServices.service.AbsentProcessRoleService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
@Path("pss/")
public class AbsentProcessRoleController {
    @Inject
    private AbsentProcessRoleService absentProcessRoleService;
    @Path("/getabsentprocessrole")
    @POST
    public Response getAbsentProcessRole(@RequestBody AbsentProcessRoleRequest absentProcessRoleRequest){
        try{
            String response = absentProcessRoleService.getAbsentProcessRole(absentProcessRoleRequest);
            return Response.ok(ApiResponse.success(response)).build();
        } catch(PssException e){
            e.getMessage();
            return  Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }

    }
}

