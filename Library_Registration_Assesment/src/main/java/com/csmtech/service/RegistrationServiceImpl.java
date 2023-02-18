package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.Registration_Details;
import com.csmtech.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegisterService{
	
	@Autowired
	private RegistrationRepository regRepo;
	
	@Override
	public List<Registration_Details> getAllRegistration() {
		return regRepo.findAll();
	}

	@Override
	public Registration_Details saveDetails(Registration_Details details) {
		return regRepo.save(details);
	}

	public List<Registration_Details> getByLibrary(String library_name) {
		return regRepo.getByLibrary(library_name);
		
	}

	public Registration_Details getRegisterById(Integer id) {
		return regRepo.updateData(id);
	}
	
}
