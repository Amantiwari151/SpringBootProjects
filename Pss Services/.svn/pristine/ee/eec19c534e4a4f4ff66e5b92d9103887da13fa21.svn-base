package gov.pssServices.pssServices.repoImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.PensionerListRepo;
import gov.pssServices.pssServices.request.PensionerListRequest;
import gov.pssServices.pssServices.response.PensionerListResponse;
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
public class PensionerListRepoImpl implements PensionerListRepo {
    @Inject
    @Named("PSN_RW")
    private DataSource testDataSource;
    @Override
    public List<PensionerListResponse> getAllPensionerList(PensionerListRequest pensionerListRequest) throws PssException {
        Connection connection = null;
        try{
            List<PensionerListResponse> list =new ArrayList<>();
            connection = this.testDataSource.getConnection();
            String sql = "    SELECT\n" +
                    "    x1.PENSIONER_ID,\n" +
                    "    MAX(CASE WHEN x1.doc_type_id = 34 THEN x1.dms_doc_id END) AS Psn_Kit_DMSDocID,\n" +
                    "    MAX(CASE WHEN x1.doc_type_id = 35 THEN x1.dms_doc_id END) AS Psn_Set_DMSDocID,\n" +
                    "    MAX(CASE WHEN x1.doc_type_id = 36 THEN x1.dms_doc_id END) AS FR_DMSDocID,\n" +
                    "    x2.name_en,\n" +
                    "    x2.employee_code,\n" +
                    "    x3.request_id,\n" +
                    "    x2.ppo_no\n" +
                    "FROM\n" +
                    "    PSN.psn_doc x1\n" +
                    "    INNER JOIN PSN.psn_personal_dtls x2 ON x1.PENSIONER_ID = x2.PENSIONER_ID\n" +
                    "    INNER JOIN wf.request_wf_instance x3 ON JSON_VALUE(x3.rqst_prcs_smry_data, '$.emp_Id' ERROR ON ERROR) = x2.employee_id\n" +
                    "    INNER JOIN wf.request_wf_transaction x4 ON x3.current_stage = x4.task_tran_id AND x3.request_id = x4.request_id\n" +
                    "WHERE\n" +
                    "    x3.status = 'Complete'\n" +
                    "    AND x4.action_taken = 'ARV'\n" +
                    "    AND x1.doc_type_id IN (34, 35, 36)\n" +
                    "    AND x1.created_by_a_id = ?\n" +
                    "GROUP BY\n" +
                    "    x1.PENSIONER_ID,\n" +
                    "    x2.name_en,\n" +
                    "    x2.employee_code,\n" +
                    "    x3.request_id,\n" +
                    "    x2.ppo_no\n";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pensionerListRequest.getCreatedByaId());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                PensionerListResponse pensionerListResponse= new PensionerListResponse();
                pensionerListResponse.setPensionerId(rs.getString("PENSIONER_ID")!= null ? rs.getString("PENSIONER_ID") : "");
                pensionerListResponse.setPsnKitDmsDocId(rs.getString("Psn_Kit_DMSDocID")!= null ? rs.getString("Psn_Kit_DMSDocID") : "");
                pensionerListResponse.setPsnSetDmsDocId(rs.getString("Psn_Set_DMSDocID")!= null ? rs.getString("Psn_Set_DMSDocID") : "");
                pensionerListResponse.setFrDmsDocId(rs.getString("FR_DMSDocID")!= null ? rs.getString("FR_DMSDocID") : "");
                pensionerListResponse.setNameEn(rs.getString("NAME_EN")!= null ? rs.getString("NAME_EN") : "");
                pensionerListResponse.setEmployeeCode(rs.getString("EMPLOYEE_CODE")!= null ? rs.getString("EMPLOYEE_CODE") : "");
                pensionerListResponse.setRequestId(rs.getString("REQUEST_ID")!= null ? rs.getString("REQUEST_ID") : "");
                pensionerListResponse.setPpoNo(rs.getString("ppo_no")!= null ? rs.getString("ppo_no") : "");
                list.add(pensionerListResponse);
            }
            rs.close();
            ps.close();
            return list;
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error - " + e.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error - " + e.getMessage());
            throw new PssException("Error : Something went wrong");
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
