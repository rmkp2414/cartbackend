package com.manuja.shoppingapp.serviceImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manuja.shoppingapp.dto.LoginDto;
import com.manuja.shoppingapp.dto.ProductDetailsDto;
import com.manuja.shoppingapp.dto.ResponseDto;
import com.manuja.shoppingapp.dto.SignupDto;
import com.manuja.shoppingapp.dto.UserDto;
import com.manuja.shoppingapp.entity.Product;
import com.manuja.shoppingapp.entity.User;
import com.manuja.shoppingapp.repository.ProductRepository;
import com.manuja.shoppingapp.repository.UserRepository;
import com.manuja.shoppingapp.service.LoginService;
import com.manuja.shoppingapp.service.ProductService;
import com.manuja.shoppingapp.util.StatusMessages;
import com.manuja.shoppingapp.util.UserType;

@Service
public class LoginServiceImpl implements LoginService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService productService;
	
	@Override
	public UserDto login(LoginDto loginDto, String userLevel) {
		
		User user = userRepository.findOneByUsername(loginDto.getUsername());
		if(user != null && user.getPassword().equals(hashPass(loginDto.getPassword()))) {
			
			List<Product> products = productRepository.findAll();
			List<ProductDetailsDto> productDetailsDtos = new ArrayList<ProductDetailsDto>();
			for (Product product : products) {
				productDetailsDtos.add(productService.convertProductToDto(product));
			}
			
			
			if(userLevel.equals("admin,employee")) {
				// Admin Users
				if(user.getUserType().equals(UserType.ADMIN.getUserType()) || user.getUserType().equals(UserType.EMPLOYEE.getUserType())) {
					logger.info("Found user with correct password..");
					UserDto userDto = new UserDto();
					userDto.setUserId(user.getId().toString());
					userDto.setUsername(user.getUsername());
					userDto.setUserType(user.getUserType()); 
					userDto.setProducts(productDetailsDtos);
					return userDto;
				}
			}
			
			if(userLevel.equals("customer")) {
				// Customer
				if(user.getUserType().equals(UserType.CUSTOMER.getUserType())) {
					logger.info("Found user with correct password..");
					UserDto userDto = new UserDto();
					userDto.setUserId(user.getId().toString());
					userDto.setUsername(user.getUsername());
					userDto.setUserType(user.getUserType()); 
					userDto.setProducts(productDetailsDtos);
					return userDto;
				}
			}
			
			return null;
		}else {
			logger.info("Incorect user password..");
			return null;
		}
	}

	@Override
	public ResponseDto signup(SignupDto signupDto, UserType userType) {
		User user = userRepository.findOneByUsername(signupDto.getUsername());
		ResponseDto responseDto = new ResponseDto();
		if(user != null) {
			// user already exists.
			responseDto.setStatus(false);
			responseDto.setStatusMessage(StatusMessages.USER_ALREADY_EXISTS.getStatusMessage());
			responseDto.setData(null);
			
			return responseDto;
		}else {
			User newUser = new User();
			newUser.setUsername(signupDto.getUsername());
			newUser.setPassword(hashPass(signupDto.getPassword()));
			newUser.setUserType(userType.getUserType());
			newUser.setAddressLine1(signupDto.getAddressLine1());
			newUser.setAddressLine2(signupDto.getAddressLine1());
			newUser.setCity(signupDto.getCity());
			newUser.setCountry(signupDto.getCity());
			newUser.setEmail(signupDto.getEmail());
			newUser.setFirstName(signupDto.getFirstName());
			newUser.setLastName(signupDto.getLastName());
			newUser.setPhoneNumber(signupDto.getPhoneNumber());
			newUser.setProvince(signupDto.getProvince());
			newUser.setZipCode(signupDto.getZipCode());
			
			newUser = userRepository.save(newUser);
			logger.info("New user created with ID : " + newUser.getId()); 
			// TODO Add customer entity to DB
			
			responseDto.setStatus(true);
			responseDto.setStatusMessage(StatusMessages.SUCCESSFUL.getStatusMessage());
			responseDto.setData(null);
			return responseDto;
		}
	}

	private String hashPass(String password) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes());
		    byte[] digiest = messageDigest.digest();
		    String hashedOutput = DatatypeConverter.printHexBinary(digiest);
		    return hashedOutput;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "123123";
		}
	}
	
	
	
	

}
