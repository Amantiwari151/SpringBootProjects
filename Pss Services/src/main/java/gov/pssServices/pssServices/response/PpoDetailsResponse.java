package gov.pssServices.pssServices.response;

import lombok.Data;

@Data
public class PpoDetailsResponse {
    private String ppoNo;
    private String cpoNo;
    private String pensionerId;
    private String nameEn;
    private String employeeCode;
    private String PsnAmount;
    private String ppoAprvDate;
    private String familyPsnAmt;
    private String enhancePsnAmt;
    private String enhancePsnStart;
    private String enhancePsnEnd;
    private String cmutAmt;
    private String cmutMonthlyAmt;
    private String effectiveCmutDt;
    private String psnTypeId;
    private String psnZone;
    private String ssoId;
    private String treasuryCode;
    private String isActive;
    private String cmutEndDt;
    private String finalPsnAmt;
    private String yearlyAmtAftCmutDedu;
    private String yearlySalWtCmut;
    private String cpoCount;

}
