package gov.pssServices.pssServices.repoImpl;

import com.google.gson.Gson;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.NomineeDetailsRepo;
import gov.pssServices.pssServices.request.NomineeDetailsRequest;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.*;

@Dependent
public class NomineeDetailsRepoImpl implements NomineeDetailsRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public String getNomineeDetails(NomineeDetailsRequest nomineeDetailsRequest) throws PssException {
       String response = "";
        Gson gson = new Gson();
        gson.toJson(nomineeDetailsRequest);

        try(Connection conn = this.testDataSource.getConnection();
            CallableStatement cstmt=conn.prepareCall("{call PSN.SP_PSS_GET_NOMINEE11 (?,?)}"))
        {
            cstmt.setString(1, nomineeDetailsRequest.getReq());
            cstmt.registerOutParameter(2, Types.CLOB);
            cstmt.execute();
            Clob clob = (Clob) cstmt.getObject(2);
                response = clob.getSubString(1, (int) clob.length());
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
}