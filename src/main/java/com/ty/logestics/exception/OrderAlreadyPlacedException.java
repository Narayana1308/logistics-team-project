package com.ty.logestics.exception;

public class OrderAlreadyPlacedException extends RuntimeException {
	private String message="order already placed";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
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
