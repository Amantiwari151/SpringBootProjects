package gov.pssServices.pssServices.repo;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.request.AbsentProcessRoleRequest;

public interface AbsentProcessRoleRepo {
    String getAbsentProcessRole(AbsentProcessRoleRequest absentProcessRoleRequest) throws PssException;
}
