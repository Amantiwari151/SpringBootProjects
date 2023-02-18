package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.csmtech.model.Registration_Details;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration_Details, Integer>{
	@Query("From Registration_Details where library.library_name = :library_name") 
	List<Registration_Details> getByLibrary(String library_name);
	
	@Query("From Registration_Details where registration_id = :id")
	Registration_Details updateData(Integer id);
	
}
