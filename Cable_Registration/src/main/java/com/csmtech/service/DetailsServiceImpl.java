package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.Details;
import com.csmtech.repository.DetailsRepository;

@Service
public class DetailsServiceImpl implements DetailsService{
	
	@Autowired
	private DetailsRepository dRepo;
	
	@Override
	public List<Details> getAllDetails() {
		return dRepo.findAll();
	}

	@Override
	public Details saveDetails(Details details) {
		return dRepo.save(details);
	}

}
