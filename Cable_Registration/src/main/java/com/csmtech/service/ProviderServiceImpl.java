package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.Provider;
import com.csmtech.repository.ProviderRepository;

@Service
public class ProviderServiceImpl implements ProviderService{
	
	@Autowired
	private ProviderRepository pRepo;
	
	@Override
	public List<Provider> getAllProvider() {
		return pRepo.findAll();
	}

}
