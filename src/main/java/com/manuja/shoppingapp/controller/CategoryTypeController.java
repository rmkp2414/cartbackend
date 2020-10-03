package com.manuja.shoppingapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manuja.shoppingapp.dto.CategoryDto;
import com.manuja.shoppingapp.dto.ResponseDto;
import com.manuja.shoppingapp.service.CategoryTypeService;

@Controller
public class CategoryTypeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private CategoryTypeService categoryTypeService;
    
    @GetMapping("/adminPortal/categories")
    public String adminCategories(ModelMap modelMap) {
    	logger.info("Running Admin Categories GET API Call..");
    	List<CategoryDto> categories = categoryTypeService.getAllCategories();
        modelMap.addAttribute("categories",categories);
    	return "AdminCategories";      
    }
    
    @GetMapping("/adminPortal/addCategory")
    public String addCategory(ModelMap modelMap) {
    	logger.info("Running Admin portal add category GET API Call..");
    	return "AddCategory";      
    }
    
    @PostMapping("/adminPortal/addCategorySubmit")
    public String addCategorySubmit(@ModelAttribute CategoryDto categoryDto, ModelMap modelMap) {
    	logger.info("Running addProductSubmit POST API Call..");
    	logger.info("Add Product Submit with details..." + categoryDto.getCategoryType() + " | " + categoryDto.getDescription()); 
    	ResponseDto responseDto = categoryTypeService.createCategory(categoryDto);
    	//UserDto userDto = loginService.login(loginDto);
    	if(responseDto.getStatus()) {
    		List<CategoryDto> categories = categoryTypeService.getAllCategories();
            modelMap.addAttribute("categories",categories);
        	return "AdminCategories"; 
    	}else {
    		modelMap.addAttribute("message",responseDto.getStatusMessage());
    		return "AddCategory"; 
    	}
    }
    
    @GetMapping("/adminPortal/deleteCategory/{id}")
    public ModelAndView deleteProduct(@PathVariable Integer id, ModelMap modelMap) {
    	logger.info("Running Delete Category GET API Call..");
    	logger.info("Deleting Category with id :" + id); 
    	ResponseDto responseDto = categoryTypeService.deleteCategory(id);
    	List<CategoryDto> categories = categoryTypeService.getAllCategories();
        modelMap.addAttribute("categories",categories);
        return new ModelAndView("redirect:" + "/adminPortal/categories"); 
    }
    
    
    @GetMapping("/adminPortal/updateCategory/{id}")
    public String updateCategory(@PathVariable Integer id, ModelMap modelMap) {
    	logger.info("Running updateCategory GET API Call with id : " + id);
    	CategoryDto category = categoryTypeService.findById(id);

    	if(category != null) {
    		logger.info("Category data taken from DB with id :" + category.getId()); 
            modelMap.addAttribute("category",category);
            return "UpdateCategory";
    	}else {
    		List<CategoryDto> categories = categoryTypeService.getAllCategories();
            modelMap.addAttribute("categories",categories);
        	return "AdminCategories"; 
    	}
    }
    
    @PostMapping("/adminPortal/updateCategorySubmit")
    public String updateProductSubmit(@ModelAttribute CategoryDto categoryDto, ModelMap modelMap) {
    	logger.info("Running updateProductSubmit POST API Call..");
    	logger.info("Update Product Submit with details..." + categoryDto.getCategoryType() + " | " + categoryDto.getDescription()); 
    	ResponseDto responseDto = categoryTypeService.updateCategory(categoryDto);

    	List<CategoryDto> categories = categoryTypeService.getAllCategories();
        modelMap.addAttribute("categories",categories);
    	return "AdminCategories";
    }
    
}
