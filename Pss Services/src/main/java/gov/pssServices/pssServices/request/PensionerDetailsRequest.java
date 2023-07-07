

package gov.pssServices.pssServices.request;

import lombok.Data;
import javax.validation.constraints.Pattern;

@Data
public class PensionerDetailsRequest {
    @Pattern(regexp = "[0-9]{0,19}",message = "invalid PPONO")
    private String ppoNo;
}
