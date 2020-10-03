package com.manuja.shoppingapp.service;

import com.manuja.shoppingapp.dto.LoginDto;
import com.manuja.shoppingapp.dto.ResponseDto;
import com.manuja.shoppingapp.dto.SignupDto;
import com.manuja.shoppingapp.dto.UserDto;
import com.manuja.shoppingapp.util.UserType;

public interface LoginService {
	
	public UserDto login(LoginDto loginDto, String userType);

	public ResponseDto signup(SignupDto signupDto, UserType employee);
	
}
