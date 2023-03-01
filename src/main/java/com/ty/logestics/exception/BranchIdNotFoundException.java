package com.ty.logestics.exception;

public class BranchIdNotFoundException extends RuntimeException{
	private String message="Branch id not found";

	public BranchIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BranchIdNotFoundException() {
		super();
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
