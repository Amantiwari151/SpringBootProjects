package gov.pssServices.pssServices.repoImpl;

import com.google.gson.Gson;
import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.MarkReliveRepo;
import gov.pssServices.pssServices.response.MarkReliveResponse;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.*;

@Dependent
public class MarkReliveRepoImpl implements MarkReliveRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;

    @Override
    public String updatePersonalDetailsAll(MarkReliveResponse updatePersonalDetailsRequest) throws PssException {
        String response = "";
        Gson gson = new Gson();
        gson.toJson(updatePersonalDetailsRequest);

        try(Connection conn = this.testDataSource.getConnection();
            CallableStatement cstmt=conn.prepareCall("{call PSN.SP_save_relieve_dtl (?,?,?,?,?,?,?)}"))
        {
            cstmt.setString(1, updatePersonalDetailsRequest.getIsRelive());
            cstmt.setString(2, updatePersonalDetailsRequest.getRemarkRelive());
            cstmt.setString(3, updatePersonalDetailsRequest.getPendingIssue());
            cstmt.setString(4, updatePersonalDetailsRequest.getDeOrCourt());
            cstmt.setDate(5, updatePersonalDetailsRequest.getDeCourtDate());
            cstmt.setString(6, updatePersonalDetailsRequest.getEmployeeId());
            cstmt.registerOutParameter(7, Types.CLOB);
            cstmt.execute();

            Clob clob = (Clob) cstmt.getObject(7);
            response = clob.getSubString(1, (int) clob.length());
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
