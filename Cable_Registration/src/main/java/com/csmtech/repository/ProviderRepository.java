package com.csmtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

}
