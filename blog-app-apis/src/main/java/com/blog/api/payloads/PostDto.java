package com.blog.api.payloads;

import java.util.Date;

import com.blog.api.entities.Category;
import com.blog.api.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	
	private String title;
	
	private String content;
	
	private String image;
	
	private Date addedDate;
	
	private UserDto user;
	
	private CategoryDto category;
}
