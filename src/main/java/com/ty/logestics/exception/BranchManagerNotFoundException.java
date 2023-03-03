package com.ty.logestics.exception;

public class BranchManagerNotFoundException extends RuntimeException{
	private String message="Branch Manager Not Found";

	public BranchManagerNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BranchManagerNotFoundException() {
		super();
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
