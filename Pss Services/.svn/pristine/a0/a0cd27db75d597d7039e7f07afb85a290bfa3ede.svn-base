package gov.pssServices.pssServices.serviceImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.json.JSONArray;

import gov.pssServices.pssServices.exception.PssException;
import gov.pssServices.pssServices.repo.BankAccountDetailsRepo;
import gov.pssServices.pssServices.request.BankAccountDetailsRequest;
import gov.pssServices.pssServices.service.BankAccountDetailsService;

@ApplicationScoped
public class BankAccountDetailsServiceImpl implements BankAccountDetailsService{
	
	@Inject
	private BankAccountDetailsRepo bankAccountDetailsRepo;
	
	@Override
	public JSONArray getBankAccountDetails(BankAccountDetailsRequest bankAccountDetailsRequest) throws PssException {
		return bankAccountDetailsRepo.getBankAccountDetails(bankAccountDetailsRequest);
	}

}
