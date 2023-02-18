package com.blog.api.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	
	@NotBlank
	@Size(min = 3,message="Please Enter CategoryTitle more than 3 character")
	private String categoryTitle;
	
	@NotBlank
	@Size(max=100,min=10 ,message = "CategoryDescription Should be minimum of 10 characters and maximum to 100 characters")
	private String categoryDescription;
	
}
