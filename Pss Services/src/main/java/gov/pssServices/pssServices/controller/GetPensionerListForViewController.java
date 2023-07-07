package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.GetPensionerListForViewRequest;
import gov.pssServices.pssServices.response.GetPensionerListForViewResponse;
import gov.pssServices.pssServices.service.GetPensionerListForViewService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pss")
public class GetPensionerListForViewController {

    @Inject
    private GetPensionerListForViewService getPensionerListForViewService;

    @Path("/getpensionerlistforview")
    @POST
    public Response employeeDetails(@RequestBody GetPensionerListForViewRequest getPensionerListForViewRequest){
        try{
            List<GetPensionerListForViewResponse> dtls= getPensionerListForViewService.getEmployeeDetails(getPensionerListForViewRequest);
            return Response.ok(ApiResponse.success(dtls)).build();
        } catch(PssException e){
            e.getMessage();
            return  Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }

    }
}

