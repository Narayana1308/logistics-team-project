package com.ty.logestics.exception;

public class ProductIdNotFoundException  extends RuntimeException{
	
	private String message=" product id not found";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ProductIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	
	public ProductIdNotFoundException() {
		super();
	}
	

}
