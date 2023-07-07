package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.FamilyDetailsRequest;
import gov.pssServices.pssServices.service.FamilyDetailsService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.json.JSONArray;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("pss")
public class FamilyDetailsController {
    @Inject
    private FamilyDetailsService familyDetailsService;

    @Path("getfamilydetails")
    @POST
    public Response familyDetails(@RequestBody FamilyDetailsRequest familyDetailsRequest) {
        try {
            JSONArray response = familyDetailsService.familyDetails(familyDetailsRequest);
            return Response.ok(ApiResponse.success(response.toList())).build();
        } catch (PssException e) {
            e.getMessage();
            return Response.ok(ApiResponse.error(Error.create("", e.getMessage()))).build();
        }
    }
}

