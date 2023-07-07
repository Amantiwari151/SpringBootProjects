package gov.pssServices.pssServices.response;

import lombok.Data;

@Data
public class DeDetailsResponse {
    private String deTypeId;
    private String deStartDt;
    private String deEndDt;
    private String deRemark;
    private String penaltyType;
}
