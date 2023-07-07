package gov.pssServices.pssServices.controller;

import gov.pssServices.pssServices.common.ApiResponse;
import gov.pssServices.pssServices.common.Error;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.response.MarkReliveResponse;
import gov.pssServices.pssServices.response.MessageResponse;
import gov.pssServices.pssServices.response.PensionerDocumentResponse;
import gov.pssServices.pssServices.service.PensionerDocumentService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pss/")
public class PensionerDocumentController {
    @Inject
    private PensionerDocumentService pensionerDocumentService;
    @Path("pensionerdocument")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response pensionerDocument(@RequestBody PensionerDocumentResponse pensionerDocumentResponse){
        try{
            int pensionerDocs= pensionerDocumentService.pensionerDocument(pensionerDocumentResponse);
            MessageResponse res= new MessageResponse();


            if(pensionerDocs==1) {
                res.setMessage("data is updated successfully");
                res.setStatus("success");
                return Response.ok(res).build();
            }
            else {
                res.setMessage("data is not updated ");
                res.setStatus("failed");
                return Response.ok(res).build();
            }
        } catch(PssException e){
            e.getMessage();
            return Response.ok(ApiResponse.error(Error.create("",e.getMessage()))).build();
        }

    }
}


