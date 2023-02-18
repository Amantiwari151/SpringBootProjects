package com.blog.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.api.repositories.UserRepository;

@SpringBootTest
class BlogAppApisApplicationTests {
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest() {
		
		String className = this.userRepo.getClass().getName();
		Package package1 = this.userRepo.getClass().getPackage();
		System.out.println(className);
		System.out.println(package1);
	}
}
