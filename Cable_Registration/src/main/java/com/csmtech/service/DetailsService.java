package com.csmtech.service;

import java.util.List;

import com.csmtech.model.Details;

public interface DetailsService {

	List<Details> getAllDetails();
	
	Details saveDetails(Details details);
	
}
