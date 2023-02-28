package com.ty.logestics.exception;

public class UserEmailNotFoundException  extends RuntimeException{


	private String message="email not fount";
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserEmailNotFoundException(String message) {
		super();
		this.message = message;
	}

	public UserEmailNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
