package com.ty.logestics.exception;

public class OrderAlreadyPlacedException extends RuntimeException {
	private String message="order already placed";
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public OrderAlreadyPlacedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderAlreadyPlacedException(String message) {
		super();
		this.message = message;
	}
	
	
	

}
