package com.manuja.shoppingapp.util;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manuja.shoppingapp.entity.User;
import com.manuja.shoppingapp.repository.UserRepository;
import com.manuja.shoppingapp.service.UserService;
import com.manuja.shoppingapp.service.UserServiceImpl;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//return new User("foo","foo",new ArrayList<>());
		//return new MyUserDetails(username);
		Optional<User> user = userRepository.findByUsername(username);

		user.orElseThrow(()-> new UsernameNotFoundException("No User available in the database with the name :"+ username));
		
		return user.map(MyUserDetails::new).get();
		//return new MyUserDetails(user);
	}
	

	
}
