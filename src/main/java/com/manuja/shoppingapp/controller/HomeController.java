package com.manuja.shoppingapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.manuja.shoppingapp.dto.LoginDto;
import com.manuja.shoppingapp.dto.ProductDetailsDto;
import com.manuja.shoppingapp.service.HomeService;
import com.manuja.shoppingapp.service.ProductService;
import com.manuja.shoppingapp.service.UserService;

@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    UserService userService;
    
    @Autowired
    HomeService homeService;
    
    @Autowired
    ProductService productService;

    @GetMapping("/homeaa")
    public String greetingSubmit(@ModelAttribute LoginDto loginDto, Model model) {
    	logger.info("Running login POST API Call.." + model.getAttribute("userId"));
    	logger.info("Login with details..." + loginDto.getUsername() + " | " + loginDto.getPassword()); 
    	List<ProductDetailsDto> products = productService.getAllProducts();
    	model.addAttribute("products", products);
    	model.addAttribute("userId", 1);
    	return "Home";
    }

}
