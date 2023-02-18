package com.blog.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//we can declare bean in @SpringBootApplication class
//because we can configure beans into this class(do configure model maper here)

@SpringBootApplication
public class BlogAppApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}
	
//	make it bean from that spring container will create it's object automatically
	@Bean 
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
