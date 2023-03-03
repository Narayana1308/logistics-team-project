package com.ty.logestics.exception;

public class InvalidPasswordException extends RuntimeException {
	private String message="invalid passsword";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InvalidPasswordException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidPasswordException(String message) {
		super();
		this.message = message;
	}
	
	

}
