package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.AbsentProcessRoleRepo;
import gov.pssServices.pssServices.request.AbsentProcessRoleRequest;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Types;

@Dependent
public class AbsentProcessRoleRepoImpl implements AbsentProcessRoleRepo {
    @Inject
    @Named("WF_RW")
    private DataSource testDataSource;
    @Override
    public String getAbsentProcessRole(AbsentProcessRoleRequest absentProcessRoleRequest) throws PssException {
        try(Connection conn = this.testDataSource.getConnection();
            CallableStatement cstmt=conn.prepareCall("{call WF.GET_Absent_Process_Role_Assignment(?,?,?)}"))
        {
            cstmt.setInt(1, absentProcessRoleRequest.getAssignmentId());
            cstmt.registerOutParameter(3, Types.CLOB);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.execute();
            String str = cstmt.getString(2);

            if(str.equalsIgnoreCase("1")){

                Clob clob = (Clob) cstmt.getObject(3);
                return  clob.getSubString(1, (int) clob.length());

            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}