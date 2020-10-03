package com.manuja.shoppingapp.util;

public enum StatusMessages {

	SUCCESSFUL("successful"), 
	USER_ALREADY_EXISTS("Username already taken, Please try again with another username!"),
	ITEM_NOT_EXIST("Sorry, Item you are looking for is not avialable anymore.."),
	ITEM_CREATION_FAILED("Sorry the item can not be created aT this moment"),
	ITEM_DELETED("Deleted Succesfully"),
	ITEM_DELETION_FAILED("Item Deletion Failed");
	 
	private String statusMessage;
	
	StatusMessages(String statusMessgae){
		this.setStatusMessage(statusMessgae);
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}
