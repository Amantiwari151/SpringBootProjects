package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PendingListRepo;
import gov.pssServices.pssServices.request.PendingListRequest;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Types;

@Dependent
public class PendingListRepoImpl implements PendingListRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    String response = "";
    @Override
    public String getPendingList(PendingListRequest pendingListRequest) throws PssException {
        try(Connection conn = this.testDataSource.getConnection();
            CallableStatement cstmt=conn.prepareCall("{call  PSN.SP_ESIGNPENDINGLIST(?,?,?)}"))
        {
            cstmt.setInt(1, pendingListRequest.getAssignmentId());
            cstmt.registerOutParameter(2, Types.CLOB);
            cstmt.registerOutParameter(3, Types.VARCHAR);
            cstmt.execute();
            String str = cstmt.getString(3);

            if(str.equalsIgnoreCase("SUCCESS")) {
                Clob clob = (Clob) cstmt.getObject(2);

                if (clob == null) {
                    return "no data found";
                } else {
                     response = clob.getSubString(1, (int) clob.length());
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
}

