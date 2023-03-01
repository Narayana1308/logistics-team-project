package com.ty.logestics.exception;

public class CompanyIdNotFoundException extends RuntimeException{
	
private String message="Company Id Not Found";
	
	@Override
	public String getMessage() {
		return message;
	}

	public CompanyIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public CompanyIdNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

}
