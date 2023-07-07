package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.NomineeDetailsRequest;
import gov.pssServices.pssServices.request.ProfileDetailsRequest;
import gov.pssServices.pssServices.service.ProfileDetailsService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pss")
public class ProfileDetailsController {
    @Inject
    private ProfileDetailsService profileDetailsService;
    @Path("/getprofiledetails")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ProfileDetails(@RequestBody ProfileDetailsRequest profileDetailsRequest){

        try{
            JSONObject response = profileDetailsService.ProfileDetails(profileDetailsRequest);
            return Response.ok(ApiResponse.success(response.toMap())).build();
        } catch(PssException e){
            e.getMessage();
            return  Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }
    }


    @Path("/getprofiledetailsdata")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ProfileDetailsDummy(@RequestBody ProfileDetailsRequest profileDetailsRequest){

        try{
            JSONArray response = profileDetailsService.ProfileDetailsDummy(profileDetailsRequest);
            return Response.ok(ApiResponse.success(response.toList())).build();
        } catch(PssException e){
            e.getMessage();
            return  Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }
    }
}


