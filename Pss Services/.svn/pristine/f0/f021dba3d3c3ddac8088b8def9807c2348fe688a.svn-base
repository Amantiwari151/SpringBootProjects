package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionOtpRepo;
import gov.pssServices.pssServices.request.PensionOtpRequest;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Dependent
public class PensionOtpRepoImpl implements PensionOtpRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public List<PensionOtpRequest> getPensionerOtpAll(PensionOtpRequest pensionOtpRequest) throws PssException {
        Connection connection = null;

        try {
            connection = this.testDataSource.getConnection();
            String sql = "insert into  PSN.psn_otp(OTP,MOBILE_NO)\n" +
                    "values(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, pensionOtpRequest.getOtp());

            ps.setLong(2, pensionOtpRequest.getMobNo());
            int rowInserted = ps.executeUpdate();
            ps.close();
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
            return null;
        }
    }
}