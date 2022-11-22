package com.fortheadvancementoflearning.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortheadvancementoflearning.blog.entities.Categories;
import com.fortheadvancementoflearning.blog.exceptions.ResourceNotFoundException;
import com.fortheadvancementoflearning.blog.payloads.CategoryDto;
import com.fortheadvancementoflearning.blog.repositories.CategoryRepo;
import com.fortheadvancementoflearning.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Categories cat = this.modelMapper.map(categoryDto, Categories.class);
		Categories addedcat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedcat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryID) {
		Categories cat = this.categoryRepo.findById(categoryID).
				orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryID));
		
		cat.setCategoryTitle(categoryDto.getCategorytitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Categories updatedcat = this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedcat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryID) {
		Categories cat = this.categoryRepo.findById(categoryID).
				orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryID));
        this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto getCategory(Integer categoryID) {
		Categories cat = this.categoryRepo.findById(categoryID).
				orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryID));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List <Categories> categories = this.categoryRepo.findAll();
		List <CategoryDto> catDtos = categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}

}
