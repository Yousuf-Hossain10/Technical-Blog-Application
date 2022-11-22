package com.fortheadvancementoflearning.blog.services;

import java.util.List;

import com.fortheadvancementoflearning.blog.payloads.CategoryDto;

public interface CategoryService {

	public CategoryDto createCategory (CategoryDto categoryDto);
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryID);
	public void deleteCategory(Integer categoryID);
	public CategoryDto getCategory(Integer categoryID);
	public List<CategoryDto> getCategories();
	
}
