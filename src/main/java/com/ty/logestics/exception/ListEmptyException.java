package com.ty.logestics.exception;

public class ListEmptyException extends RuntimeException {
	private String message="Branch List is empty";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ListEmptyException(String message) {
		super();
		this.message = message;
	}

	public ListEmptyException() {
		super();
		
	}
	

}
