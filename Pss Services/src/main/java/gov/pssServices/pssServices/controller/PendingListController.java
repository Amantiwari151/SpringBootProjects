package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.PendingListRequest;
import gov.pssServices.pssServices.service.PendingListService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("pss/")
public class PendingListController {
    @Inject
    private PendingListService pendingListService;
    @Path("/getpendinglist")
    @POST
    public Response getPendingList(@RequestBody PendingListRequest pendingListRequest){
        try{
            String pendingListResponse = pendingListService.getPendingList(pendingListRequest);
            return Response.ok(ApiResponse.success(pendingListResponse)).build();
        } catch(PssException e){
            e.getMessage();
            return  Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }

    }
}

