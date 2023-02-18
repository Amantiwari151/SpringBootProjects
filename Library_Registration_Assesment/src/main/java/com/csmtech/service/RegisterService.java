package com.csmtech.service;

import java.util.List;

import com.csmtech.model.Registration_Details;

public interface RegisterService {
	
	
	List<Registration_Details> getAllRegistration();
	
	Registration_Details saveDetails(Registration_Details details);
}
