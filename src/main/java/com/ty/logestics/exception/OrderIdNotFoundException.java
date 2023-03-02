package com.ty.logestics.exception;

public class OrderIdNotFoundException extends RuntimeException {
	private String message="Order Id Not Found";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public OrderIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public OrderIdNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
