package com.manuja.shoppingapp.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.manuja.shoppingapp.entity.User;

public class MyUserDetails implements UserDetails {
	
	private String id;
	

	private String userName;
	private String password;
	private boolean active;
	
	private String userType;
    private String firstName;
    private String lastName;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private String zipCode;
    private String city;
    private String province;
    private String phoneNumber;
    private String email;
    
    
	
	//member variable list of granted authorities

    
    public String getId() {
		return id;
	}
    
    
	public String getUserName() {
		return userName;
	}

	public String getUserType() {
		return userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCountry() {
		return country;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	private List<GrantedAuthority> authorities;
	
//	public MyUserDetails(User user) {
//		this.userName = user.getUsername();
//		this.password = user.getPassword();
//		this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
//				.collect(Collectors.toList());
//	
//	}
	
	public MyUserDetails(User user) {
		this.id = user.getId().toString();
		this.userName = user.getUsername();
		this.password = user.getPassword();
		this.addressLine1 = user.getAddressLine1();
		this.addressLine2 = user.getAddressLine2();
		this.userType = user.getUserType();
		this.city = user.getCity();
		this.country = user.getCountry();
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.phoneNumber = user.getPhoneNumber();
		this.province = user.getProvince();
		this.zipCode = user.getZipCode();
		
		this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

	
	

}
