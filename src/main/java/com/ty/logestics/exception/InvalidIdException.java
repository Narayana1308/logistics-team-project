package com.ty.logestics.exception;

public class InvalidIdException extends RuntimeException {
	private String message="in valid id to same goods";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InvalidIdException(String message) {
		super();
		this.message = message;
	}

	public InvalidIdException() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
