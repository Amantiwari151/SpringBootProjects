package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.Subscription;
import com.csmtech.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
	
	@Autowired
	private SubscriptionRepository sRepo;
	
	@Override
	public List<Subscription> getAllSubscription() {
		return sRepo.findAll();
	}

}
