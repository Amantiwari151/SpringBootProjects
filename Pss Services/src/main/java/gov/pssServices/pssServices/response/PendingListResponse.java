package gov.pssServices.pssServices.response;

import lombok.Data;

import javax.json.bind.annotation.JsonbProperty;

@Data
public class PendingListResponse {
    @JsonbProperty("status")
    private String status;
}
