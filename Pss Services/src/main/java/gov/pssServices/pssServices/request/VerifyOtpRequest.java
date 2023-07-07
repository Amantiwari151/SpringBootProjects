package gov.pssServices.pssServices.request;

import lombok.Data;

@Data
public class VerifyOtpRequest {
    private  long mobNo;
    private int otp;
    private int ppoNo;
    private String ssoId;


}
