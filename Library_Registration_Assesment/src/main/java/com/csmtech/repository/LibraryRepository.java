package com.csmtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
	
	
}
