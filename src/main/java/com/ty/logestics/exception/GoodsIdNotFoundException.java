package com.ty.logestics.exception;

public class GoodsIdNotFoundException extends RuntimeException {
	private String message="goods id not found exception";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GoodsIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public GoodsIdNotFoundException() {
		super();
		
	}
	

}
