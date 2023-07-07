package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.response.DeDetailsResponse;
import gov.pssServices.pssServices.response.MarkReliveResponse;
import gov.pssServices.pssServices.response.MessageResponse;
import gov.pssServices.pssServices.service.MarkReliveService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pss/")
public class MarkReliveController {
    @Inject
    private MarkReliveService markReliveService;
    @Path("markrelive")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response updatePersonalDetails(@RequestBody MarkReliveResponse updatePersonalDetailsRequest){
        try{
           String pdc= markReliveService.updatePersonalDetails(updatePersonalDetailsRequest);
            return Response.ok(ApiResponse.success(pdc)).build();
        } catch(PssException e){
            e.getMessage();
            return  Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }

    }
}

