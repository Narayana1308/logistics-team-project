package com.ty.logestics.exception;

public class ShipmentIdNotFoundException extends RuntimeException {
	private String messsage="shipment id is not found";

	public String getMessage() {
		return messsage;
	}

	public void setMessage(String messsage) {
		this.messsage = messsage;
	}

	public ShipmentIdNotFoundException(String messsage) {
		super();
		this.messsage = messsage;
	}

	public ShipmentIdNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
