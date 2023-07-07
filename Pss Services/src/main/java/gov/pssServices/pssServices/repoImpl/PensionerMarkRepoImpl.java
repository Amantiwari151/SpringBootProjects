package gov.pssServices.pssServices.repoImpl;

import com.google.gson.Gson;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionerMarkRepo;
import gov.pssServices.pssServices.request.PensionerMarkRequest;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.*;

@Dependent
public class PensionerMarkRepoImpl implements PensionerMarkRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public String getPensionerMarks(PensionerMarkRequest pensionerMarkRequest) throws PssException {
        Connection conn = null;
        CallableStatement cstmt = null;
        String response = "";
        Gson gson = new Gson();
        String req = gson.toJson(pensionerMarkRequest);

        try{
            conn = this.testDataSource.getConnection();
            cstmt = conn.prepareCall("{call PSN.sp_savemarkpensioner  (?,?)}");
            Clob stmtClob = conn.createClob();
            stmtClob.setString(1, req);
            cstmt.setClob(1, stmtClob);
            cstmt.registerOutParameter(2, Types.CLOB);

            cstmt.execute();
            Clob clob = (Clob) cstmt.getObject(2);
            if(clob==null) {
                return "no data found";
            }else {
                response = clob.getSubString(1, (int) clob.length());
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return response;
    }
}

