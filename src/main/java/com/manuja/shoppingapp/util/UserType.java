package com.manuja.shoppingapp.util;

public enum UserType {

	ADMIN("Admin"),
	EMPLOYEE("Employee"),
	CUSTOMER("Customer");
	
	private String userType;
	
	UserType(String type){
		this.setUserType(type);
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	
}
