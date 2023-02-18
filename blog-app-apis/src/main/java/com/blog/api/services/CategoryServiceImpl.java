package com.blog.api.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.entities.Category;
import com.blog.api.exceptions.ResourceNotFoundException;
import com.blog.api.payloads.CategoryDto;
import com.blog.api.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category category = dtoToCategory(categoryDto);
		
		Category savedCategory = this.categoryRepo.save(category);
		
		return categoryToDto(savedCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
		
		category.setCategoryId(categoryDto.getCategoryId());
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category saveCategory = this.categoryRepo.save(category);
		
		CategoryDto categoryToDto = categoryToDto(saveCategory);
		
		return categoryToDto;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		
		CategoryDto categoryToDto = this.categoryToDto(category);
		
		return categoryToDto;
	}

	@Override
	public void deleteCategory(Integer id) {
		
		Category category = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("category","categoryId" ,id ));
		
		
		this.categoryRepo.delete(category);
		
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		
		List<Category> categoryList = this.categoryRepo.findAll();
		List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
		categoryList.forEach(category->{
			CategoryDto categoryToDto = this.categoryToDto(category);
			
			categoryDtoList.add(categoryToDto);
		});
		
		
		return categoryDtoList;
	}
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		
		return category;
	}
	
	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto = this.modelMapper.map(category,CategoryDto.class);
		
		return categoryDto;
	}
	
}
