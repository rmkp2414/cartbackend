package com.manuja.shoppingapp.service;

import java.util.List;

import com.manuja.shoppingapp.dto.CategoryDto;
import com.manuja.shoppingapp.dto.ResponseDto;


public interface CategoryTypeService {

    public CategoryDto findById(Integer id); 
    
	public List<CategoryDto> getAllCategories();
	
	public ResponseDto createCategory(CategoryDto categoryDto);
	
	public ResponseDto updateCategory(CategoryDto categoryDto);
	
	public ResponseDto deleteCategory(Integer id);
}
