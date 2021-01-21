package com.manuja.shoppingapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.manuja.shoppingapp.dto.CategoryDto;
import com.manuja.shoppingapp.dto.LoginDto;
import com.manuja.shoppingapp.dto.ProductDetailsDto;
import com.manuja.shoppingapp.dto.ResponseDto;
import com.manuja.shoppingapp.dto.SignupDto;
import com.manuja.shoppingapp.dto.UserDto;
import com.manuja.shoppingapp.service.CategoryTypeService;
import com.manuja.shoppingapp.service.HomeService;
import com.manuja.shoppingapp.service.LoginService;
import com.manuja.shoppingapp.service.ProductService;
import com.manuja.shoppingapp.service.UserService;
import com.manuja.shoppingapp.util.UserType;

@Controller
public class LoginController extends BaseController {
    
	Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    UserService userService;
    
    @Autowired
    HomeService homeService;
    
    @Autowired
    LoginService loginService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    private CategoryTypeService categoryTypeService;
        
    @GetMapping("/login")
    public String login() {
    	logger.info("Running Login GET API Call..");
    	return "Login";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto, Model model) {
    	logger.info("Running login POST API Call..");
    	logger.info("Login with details..." + loginDto.getUsername() + " | " + loginDto.getPassword()); 
    	UserDto userDto = loginService.login(loginDto, "customer");
    	List<CategoryDto> categories = categoryTypeService.getAllCategories();
    	if(1==1)
    	{
    		return "Home";
    	}
    	if(userDto != null) {
    		USER_ID = Integer.parseInt(userDto.getUserId());
    		USER_TYPE = userDto.getUserType();
    		model.addAttribute("products", userDto.getProducts());
    		model.addAttribute("userId", userDto.getUserId());
    		model.addAttribute("categories", categories);
    		return "Home";
    	}else {
    		model.addAttribute("loginstatus", "Invalid Username Password");
    		return "Login";
    	}
      
    }
    
    @GetMapping("/home")
    public String home(@ModelAttribute LoginDto loginDto, Model model) {
    	logger.info("Running login POST API Call.." + model.getAttribute("userId"));
    	logger.info("Login with details..." + loginDto.getUsername() + " | " + loginDto.getPassword()); 
    	List<ProductDetailsDto> products = productService.getAllProducts();
    	List<CategoryDto> categories = categoryTypeService.getAllCategories();
    	model.addAttribute("products", products);
    	model.addAttribute("categories", categories);
    	model.addAttribute("userId", USER_ID);
    	return "Home";
    }

    
    @GetMapping("/signup")
    public String signUp() {
    	logger.info("Running Login GET API Call..");
    	return "Signup";
    }
    
    @GetMapping("/adminPortal/signup")
    public String employeeSignUp() {
    	logger.info("Running Login GET API Call..");
    	return "EmployeeSignup";
    }
    
    
    @GetMapping("/adminPortal/login")
    public String adminLogin() {
    	logger.info("Running Admin login GET API Call..");
    	return "AdminLogin";
    }
    
    @PostMapping("/adminPortal/login")
    public String adminLogin(@ModelAttribute LoginDto loginDto, Model model) {
    	logger.info("Running login POST API Call..");
    	logger.info("Login with details..." + loginDto.getUsername() + " | " + loginDto.getPassword()); 
    	UserDto userDto = loginService.login(loginDto, "admin,employee");
    	List<CategoryDto> categories = categoryTypeService.getAllCategories();
    	if(userDto != null) {
    		USER_ID = Integer.parseInt(userDto.getUserId());
    		USER_TYPE = userDto.getUserType();
    		model.addAttribute("products", userDto.getProducts());
    		model.addAttribute("userType", USER_TYPE);
    		model.addAttribute("categories", categories);
    		return "AdminHome";
    	}else {
    		model.addAttribute("loginstatus", "Invalid Username Password");
    		return "AdminLogin";
    	}
      
    }
    
    @GetMapping("/adminPortal/home")
    public String AdminPortal(ModelMap model){
    	List<ProductDetailsDto> products = productService.getAllProducts();
    	List<CategoryDto> categories = categoryTypeService.getAllCategories();
    	model.addAttribute("products",products);
        model.addAttribute("userType", USER_TYPE);
        model.addAttribute("categories", categories);
        return "AdminHome";
    }
    
    @GetMapping("/sample")
    public String sampleEndPoint() {
    	logger.info("Running Login GET API Call..");
    	return "sample";
    }
    
    @PostMapping("/signup")
    public String signUp(@ModelAttribute SignupDto signupDto, Model model) {
    	logger.info("Running login POST API Call..");
    	logger.info("Signup with details..." + signupDto.getUsername() + " | " + signupDto.getPassword()); 
    	if(!signupDto.getPassword().equals(signupDto.getConfirmPassword())) {
    		logger.info("Signup failed, user already exists..");
    		model.addAttribute("status", false);
    		model.addAttribute("statusMessage", "Your Passwords Should Match!");
    		return "Signup";
    	}
    	ResponseDto response = loginService.signup(signupDto, UserType.CUSTOMER);
    	if(response.getStatus()) {
    		logger.info("Signup succesful, new user created..");
    		model.addAttribute("status", response.getStatus());
    		model.addAttribute("statusMessage", "User Signup Successful");
    		return "Login";
    	}else {
    		logger.info("Signup failed, user already exists..");
    		model.addAttribute("status", response.getStatus());
    		model.addAttribute("statusMessage", response.getStatusMessage());
    		return "Signup";
    		
    	}
    }
    
    @PostMapping("/adminPortal/signup")
    public String employeeSignUp(@ModelAttribute SignupDto signupDto, Model model) {
    	logger.info("Running login POST API Call..");
    	logger.info("Signup with details..." + signupDto.getUsername() + " | " + signupDto.getPassword()); 
    	if(!signupDto.getPassword().equals(signupDto.getConfirmPassword())) {
    		logger.info("Signup failed, user already exists..");
    		model.addAttribute("status", false);
    		model.addAttribute("statusMessage", "Your Passwords Should Match!");
    		return "Signup";
    	}
    	ResponseDto response = loginService.signup(signupDto, UserType.EMPLOYEE);
    	if(response.getStatus()) {
    		logger.info("Signup succesful, new user created..");
    		model.addAttribute("status", response.getStatus());
    		model.addAttribute("statusMessage", "User Signup Successful");
    		return "AdminLoginAfterSignUp";
    	}else {
    		logger.info("Signup failed, user already exists..");
    		model.addAttribute("status", response.getStatus());
    		model.addAttribute("statusMessage", response.getStatusMessage());
    		return "Signup";
    		
    	}
    }

}
