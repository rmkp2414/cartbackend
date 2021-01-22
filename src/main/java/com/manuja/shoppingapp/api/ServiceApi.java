package com.manuja.shoppingapp.api;

import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manuja.shoppingapp.dto.ProductDetailsDto;
import com.manuja.shoppingapp.entity.Cart;
import com.manuja.shoppingapp.entity.Log;
import com.manuja.shoppingapp.entity.Product;
import com.manuja.shoppingapp.entity.User;
import com.manuja.shoppingapp.service.CartService;
import com.manuja.shoppingapp.service.ProductService;
import com.manuja.shoppingapp.service.UserService;
import com.manuja.shoppingapp.util.AuthenticationRequest;
import com.manuja.shoppingapp.util.AuthenticationResponse;
import com.manuja.shoppingapp.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class ServiceApi {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String Hello() {
		return "API WORKING FINE";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)	
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
		try {		
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
				authenticationRequest.getPassword()));
		}catch(BadCredentialsException e) {
			
			throw new Exception("Incorrect User Name Or Password");
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@Autowired
	UserService userService;
	
	//register user
	@RequestMapping(value = "/register", method = RequestMethod.POST)	
	public ResponseEntity<?> registerNewUser(@RequestBody User user) throws Exception
	{
		try {	
			userService.Save(user);			
			return ResponseEntity.ok("User Created Successfully");
		}
		catch(Exception e){
//			Log.("Error /register",e.toString());
			throw new Exception("Error Occured While Creating User");
		}		

	}
	
	//signout not needed delete token from front end
	
	//getAllProducts
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)	
	public ResponseEntity<List<ProductDetailsDto>> getProducts() throws Exception 
	{
//		if(category != null)
//		{
//			List<ProductDetailsDto> result = productService.getAllProducts().stream()
//				     .filter(item -> item.getCategory().equals(category))
//				     .collect(Collectors.toList());			
//			return ResponseEntity.ok(result);			
//		}	
		
		List<ProductDetailsDto> prod = productService.getAllProducts();
		
		
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@Autowired
	CartService cartService;
	
	@RequestMapping(value = "/usercart", method = RequestMethod.GET)	
	public ResponseEntity<Cart> getCartByUser(Principal principal) throws Exception
	{
//	{	
//				String username = principal.getName();
//				jwtTokenUtil.extractUsername(principal.)
//		cartService.getUserCart(username);
//		if(category != null)
//		{
//			List<ProductDetailsDto> result = productService.getAllProducts().stream()
//				     .filter(item -> item.getCategory().equals(category))
//				     .collect(Collectors.toList());			
//			return ResponseEntity.ok(result);			
//		}	
////		
		
		
		return ResponseEntity.ok(new Cart());
	}
	
	//SaveUser cart when purchase finishes
	
	
	@GetMapping(value = "/productByCategory/{category}")
    public List<ProductDetailsDto> getProductsCat(String category)throws URISyntaxException{
        return  productService.getProductsByCategory(category);
    }

//    @GetMapping(value = "/productByCategoryy{category}")
//    public List<Product> getProductsCatt(String category)throws URISyntaxException{
//        return  productRepository.findAllByCategoryType(category);
//    }

	

	

}
