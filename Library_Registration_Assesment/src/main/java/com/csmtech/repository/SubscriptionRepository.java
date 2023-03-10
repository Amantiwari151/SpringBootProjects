package com.csmtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

}
