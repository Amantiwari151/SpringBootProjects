package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.Library;
import com.csmtech.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService{
	
	@Autowired
	private LibraryRepository libRepo;
	
	@Override
	public List<Library> getAllLibrary() {
		return libRepo.findAll();
	}

}
