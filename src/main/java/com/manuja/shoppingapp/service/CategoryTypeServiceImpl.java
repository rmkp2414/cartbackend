package com.manuja.shoppingapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuja.shoppingapp.dto.CategoryDto;
import com.manuja.shoppingapp.dto.ResponseDto;
import com.manuja.shoppingapp.entity.CategoryType;
import com.manuja.shoppingapp.repository.CategoryTypeRepository;
import com.manuja.shoppingapp.util.StatusMessages;

@Service
public class CategoryTypeServiceImpl implements CategoryTypeService {

    @Autowired
    private CategoryTypeRepository categoryTypeRepository;

    @Override
    public CategoryDto findById(Integer id) {
    	CategoryType categoryType =  categoryTypeRepository.findById(id).get();
    	CategoryDto categoryDto = convertToDto(categoryType);
		return categoryDto;
    }

	@Override
	public List<CategoryDto> getAllCategories() {
		List<CategoryType> categoryType = categoryTypeRepository.findAll();
		List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();

		for (CategoryType category : categoryType) {
			CategoryDto categoryDto = convertToDto(category);
			categoryDtos.add(categoryDto);
		}
		
		return categoryDtos;
	}
	
	@Override
	public ResponseDto createCategory(CategoryDto categoryDto) {
		CategoryType categoryType = convertDtoToDomain(categoryDto);
		CategoryType categoryTypeCreated = categoryTypeRepository.save(categoryType);
		categoryDto = convertToDto(categoryTypeCreated);
		ResponseDto responseDto = new ResponseDto();
		if(categoryDto.getId() != null) {
			responseDto.setStatus(true);
			responseDto.setStatusMessage(StatusMessages.SUCCESSFUL.getStatusMessage());
		}else {
			responseDto.setStatus(false);
			responseDto.setStatusMessage(StatusMessages.ITEM_CREATION_FAILED.getStatusMessage()); 
		}
		
		return responseDto;
	}
	
	

	@Override
	public ResponseDto updateCategory(CategoryDto categoryDto) {

		ResponseDto responseDto = new ResponseDto();
		CategoryType categoryType = convertDtoToDomain(categoryDto);
		Optional<CategoryType> categoryExisting = categoryTypeRepository.findById(categoryDto.getId());
		
		if(categoryExisting.isPresent()) {
			CategoryType categoryTypeExisting = categoryExisting.get();
			if(categoryType.getDescription() != null && !categoryType.getDescription().isEmpty()) {
				categoryTypeExisting.setDescription(categoryType.getDescription());
			}
			
			if(categoryType.getCategoryType() != null && !categoryType.getCategoryType().isEmpty()) {
				categoryTypeExisting.setCategoryType(categoryType.getCategoryType()); 
			}
			categoryType = categoryTypeRepository.save(categoryTypeExisting);
			CategoryDto categoryDto2 = convertToDto(categoryType);
			
			responseDto.setData(categoryDto2);
			responseDto.setStatus(true);
			responseDto.setStatusMessage(StatusMessages.SUCCESSFUL.getStatusMessage()); 
			return responseDto;
		}else {
			responseDto.setStatus(false);
			responseDto.setStatusMessage(StatusMessages.ITEM_CREATION_FAILED.getStatusMessage()); 
			return responseDto;
		}
	}

	@Override
	public ResponseDto deleteCategory(Integer id) {
		
		ResponseDto responseDto = new ResponseDto();
		
		if(id != null && id != 0) {
			categoryTypeRepository.deleteById(id);
			responseDto.setStatus(true);
			responseDto.setStatusMessage(StatusMessages.SUCCESSFUL.getStatusMessage()); 
			return responseDto;
		}else {
			responseDto.setStatus(false);
			responseDto.setStatusMessage(StatusMessages.ITEM_DELETED.getStatusMessage()); 
			return responseDto;
		}
	}
	
	private CategoryDto convertToDto(CategoryType categoryType){
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(categoryType.getId());
		categoryDto.setDescription(categoryType.getDescription());
		categoryDto.setCategoryType(categoryType.getCategoryType());
		
		return categoryDto;
	}
	
	private CategoryType convertDtoToDomain(CategoryDto categoryDto){
		CategoryType categoryType = new CategoryType();
		categoryType.setDescription(categoryDto.getDescription());
		categoryType.setCategoryType(categoryDto.getCategoryType());
		return categoryType;
	}
}
