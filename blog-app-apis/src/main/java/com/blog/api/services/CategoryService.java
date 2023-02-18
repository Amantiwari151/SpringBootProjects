package com.blog.api.services;

import java.util.List;

import com.blog.api.payloads.CategoryDto;

public interface CategoryService {
	
//	adding the category
	CategoryDto createCategory(CategoryDto categoryDto);
	
//	updating category
	CategoryDto updateCategory(CategoryDto categoryDto , Integer categoryId);
	
//	category By Id
	CategoryDto getCategoryById(Integer categoryId);
	
//	delete Category
	void deleteCategory(Integer id);
	
//	getAll categories
	List<CategoryDto> getAllCategories();
	
	
}
