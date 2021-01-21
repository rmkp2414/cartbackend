package com.manuja.shoppingapp.util;

public class AuthenticationRequest {

	private String username;
	private String password;
	
	
	//need this for serialization
	public AuthenticationRequest() {
	
	}
	
	public AuthenticationRequest(String username, String password) {		
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
