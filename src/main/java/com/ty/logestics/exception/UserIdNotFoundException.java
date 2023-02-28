package com.ty.logestics.exception;

public class UserIdNotFoundException extends RuntimeException {
	private String message="User id not found";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public UserIdNotFoundException() {
		super();
		
	}
	

}
