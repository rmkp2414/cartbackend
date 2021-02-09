package com.manuja.shoppingapp.api;

import java.util.List;
import java.util.stream.Collectors;

import com.manuja.shoppingapp.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.manuja.shoppingapp.dto.ProductDetailsDto;
import com.manuja.shoppingapp.dto.ResponseDto;
import com.manuja.shoppingapp.entity.CartItem;
import com.manuja.shoppingapp.entity.CategoryType;
import com.manuja.shoppingapp.entity.User;
import com.manuja.shoppingapp.repository.UserRepository;
import com.manuja.shoppingapp.service.CartItemService;
import com.manuja.shoppingapp.service.CartService;
import com.manuja.shoppingapp.service.ProductService;
import com.manuja.shoppingapp.service.UserService;
import com.manuja.shoppingapp.util.AuthenticationRequest;
import com.manuja.shoppingapp.util.AuthenticationResponse;
import com.manuja.shoppingapp.util.JwtUtil;
import com.manuja.shoppingapp.util.StatusMessages;

@RestController
@RequestMapping("/api")
public class ServiceApi {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	ProductService productService;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	UserService userService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	CartService cartService;
	
	@Autowired
	CartItemService cartItemService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String Hello() {		
		return "API WORKING FINE";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<UserDetails> getUser() {		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
		return ResponseEntity.ok(userDetails);			
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect User Name Or Password");
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> registerNewUser(@RequestBody User signupDto) throws Exception
	{
		try {			
			User user = userRepository.findOneByUsername(signupDto.getUsername());
			ResponseDto responseDto = new ResponseDto();			
			if(user != null) {
				// user already exists.
				responseDto.setStatus(false);
				responseDto.setStatusMessage(StatusMessages.USER_ALREADY_EXISTS.getStatusMessage());
				responseDto.setData(null);				
				return ResponseEntity.ok(responseDto);
			}else {
				User newUser = new User();
				newUser.setUsername(signupDto.getUsername());				
				newUser.setPassword(passwordEncoder.encode(signupDto.getPassword()));
				newUser.setUserType(signupDto.getUserType());
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
				newUser.setRoles("USER");				
				newUser = userRepository.save(newUser);
				responseDto.setStatus(true);
				responseDto.setStatusMessage(StatusMessages.SUCCESSFUL.getStatusMessage());
				responseDto.setData(newUser);
				return ResponseEntity.ok(responseDto);
			}					
		}
		catch(Exception e){
			throw new Exception("Error Occured While Creating User");
		}
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDetailsDto>> getProducts(@RequestParam(value = "cat") String cat) throws Exception
	{
		if(!cat.equals("Home"))
		{			
			List<ProductDetailsDto> products = productService.getAllProducts();
			List<ProductDetailsDto> catProds = products.stream().filter(product->  product.getCategory().equals(cat))
		                .collect(Collectors.toList());
		//	return ResponseEntity.ok(productService.getProductsByCategory(cat));
			return ResponseEntity.ok(catProds);
		}
		else
		{
			
			return ResponseEntity.ok(productService.getAllProducts());
		}		
	}

	@RequestMapping(value = "/usercart/{id}", method = RequestMethod.GET)
	public ResponseEntity<CartDto> getCartByUser(@PathVariable Integer id) throws Exception
	{
		CartDto cartDto= cartService.getUserCart(id);
		return ResponseEntity.ok(cartDto);
	}

	@RequestMapping(value = "/addtocart", method = RequestMethod.GET)
	public ResponseEntity<CartDto> addProducttoCart(@RequestParam(value = "userid") int userid,@RequestParam(value = "productid") int productid ){
				
		ResponseDto responseDto = cartService.addProductToCart(userid,productid);
//		ResponseDto responseDto = new ResponseDto();
		CartDto allUserItems = new CartDto();
		if(responseDto.getStatus().equals(true))
		{
			allUserItems = cartService.getUserCart(userid);			
		}
		return ResponseEntity.ok(allUserItems);	
	}
		
	@RequestMapping(value = "/removecartitem", method = RequestMethod.GET)
	public void removeItemFromCart(@RequestParam(value = "userid") int userid,@RequestParam(value = "itemid") int itemid){		
		CartItem cartItem = cartItemService.findbyID(itemid);
        cartItemService.Delete(cartItem);		
	}
	
}
