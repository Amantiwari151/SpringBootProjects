package gov.pssServices.pssServices.request;

import lombok.Data;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

@Data
public class PensionerMarkRequest {
    private  long employeeId;
    private  String employeeCode;
    private  String dateOfRetirement;
    private  String lastWorkingDate;
    private  String retirementTypes;
    private  String documentId;
    private List<PensionerNomineeMark> nominee;
}
