package com.ty.logestics.exception;

public class ShipmentAlreadyDoneException extends RuntimeException {
	
	private String message="shipment already done";

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ShipmentAlreadyDoneException(String message) {
		super();
		this.message = message;
	}

	public ShipmentAlreadyDoneException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
