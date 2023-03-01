package com.ty.logestics.exception;

public class GoodsIdNotFoundException  extends RuntimeException{
	
	private String msg="goods id not found";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public GoodsIdNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public GoodsIdNotFoundException() {
		super();
	}
	
	

}
