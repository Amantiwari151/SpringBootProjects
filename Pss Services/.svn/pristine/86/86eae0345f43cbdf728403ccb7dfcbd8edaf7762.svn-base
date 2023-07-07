package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionerDocumentRepo;
import gov.pssServices.pssServices.response.PensionerDocumentResponse;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class PensionerDocumentRepoImpl implements PensionerDocumentRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public int pensionerDocument(PensionerDocumentResponse pensionerDocumentResponse) throws PssException {
        Connection connection = null;
        int updatedRow=0;
        try {
            List<PensionerDocumentResponse> list = new ArrayList<>();
            connection = this.testDataSource.getConnection();
            String sql ="UPDATE\n" +
                    "   PSN.PSN_DOC\n" +
                    "SET\n" +
                    "  DMS_DOC_ID = ?\n" +
                    "WHERE\n" +
                    "  PENSIONER_ID = ?\n" +
                    "  and DOC_TYPE_ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,pensionerDocumentResponse.getDmsDocId());
            ps.setString(2,pensionerDocumentResponse.getPensionerId());
            ps.setString(3,pensionerDocumentResponse.getDocTypeId());


            int executeId=ps.executeUpdate();

            if(executeId==1) {
                System.out.println("data updated successfully");
                updatedRow = executeId;

            }else  {
                System.out.println("data not updated");
            }
            ps.close();

            return updatedRow;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - " + e.getMessage());
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error - " + e.getMessage());
            return 0;
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}