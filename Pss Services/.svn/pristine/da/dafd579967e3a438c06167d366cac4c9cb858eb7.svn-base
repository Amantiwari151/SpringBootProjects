package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.VerifyOtpRepo;
import gov.pssServices.pssServices.request.VerifyOtpRequest;
import gov.pssServices.pssServices.response.VerifyOtpResponse;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Dependent
public class VerifyOtpRepoImpl implements VerifyOtpRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public List<VerifyOtpResponse>  getVerifyOtps(VerifyOtpRequest verifyOtpRequest) throws PssException {
        List<VerifyOtpResponse> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = this.testDataSource.getConnection();
            String sql ="SELECT COUNT(*)\n" +
                    "FROM  PSN.psn_otp\n" +
                    "WHERE MOBILE_NO =?\n" +
                    "  AND OTP =?\n" +
                    "  AND CREATE_DT >= SYSTIMESTAMP - INTERVAL '15' MINUTE";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, verifyOtpRequest.getMobNo());
            ps.setInt(2, verifyOtpRequest.getOtp());
            System.out.println("The Data............" + sql);
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    VerifyOtpResponse verifyOtpResponse = new VerifyOtpResponse();
                    verifyOtpResponse.setCount(rs.getString("COUNT(*)"));
                    list.add(verifyOtpResponse);
                    int count=Integer.valueOf(verifyOtpResponse.getCount());
                    if(count!=0) {
                        String sql1 = "update PSN_PERSONAL_DTLS set SSO_ID=? where PPO_NO = ? ";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        ps1.setString(1, verifyOtpRequest.getSsoId());
                        ps1.setInt(2, verifyOtpRequest.getPpoNo());
                        int executeId = ps1.executeUpdate();
                            System.out.println("data updated successfully");
                        }else  {
                            System.out.println("data not updated");
                        }
                }
        rs.close();
        ps.close();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error - " + e.getMessage());
        return null;
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error - " + e.getMessage());
        return (List<VerifyOtpResponse>) new PssException("Error : Something went wrong");
    } finally {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
}
