package gov.pssServices.pssServices.serviceImpl;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.AbsentProcessRoleRepo;
import gov.pssServices.pssServices.request.AbsentProcessRoleRequest;
import gov.pssServices.pssServices.service.AbsentProcessRoleService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AbsentProcessRoleServiceImpl  implements AbsentProcessRoleService {
    @Inject
    private AbsentProcessRoleRepo absentProcessRoleRepo;
    @Override
    public String getAbsentProcessRole(AbsentProcessRoleRequest absentProcessRoleRequest) throws PssException {
        return absentProcessRoleRepo.getAbsentProcessRole(absentProcessRoleRequest);
    }
}
