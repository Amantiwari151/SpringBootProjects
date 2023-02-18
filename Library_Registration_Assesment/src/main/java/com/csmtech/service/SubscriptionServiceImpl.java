package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.Subscription;
import com.csmtech.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

	@Autowired
	private SubscriptionRepository subsRepo;
	
	@Override
	public List<Subscription> getAllSubscription() {
		return subsRepo.findAll();
	}

}
