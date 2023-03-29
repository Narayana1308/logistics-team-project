package com.ty.logestics.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data 
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@NotNull(message="order_type should not be null")
	@NotBlank(message="order_type should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="order type should contain characters only")
	private String oderType;
	@NotNull(message="To_Address should not be null")
	@NotBlank(message="To_Address should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="Address should contain only characters")
	private String to_Address;
	@NotNull(message="From_Address should not be null")
	@NotBlank(message="From__Address should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="Address should contain only characters")
	private String from_Address;
	
	@Min(value=100,message="the minimum charges on a order is minimum 100 rupees")
	private double charges;
	
	@Min(value=1,message="The minimum distance should be 1km")
	@Max(value=500,message="The maximum distance should be 500km")
	private double totaldistance;


	@OneToMany
	private List<Product> products;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOderType() {
		return oderType;
	}
	public void setOderType(String oderType) {
		this.oderType = oderType;
	}
	public String getTo_Address() {
		return to_Address;
	}
	public void setTo_Address(String to_Address) {
		this.to_Address = to_Address;
	}
	public String getFrom_Address() {
		return from_Address;
	}
	public void setFrom_Address(String from_Address) {
		this.from_Address = from_Address;
	}
	public double getCharges() {
		return charges;
	}
	public void setCharges(double charges) {
		this.charges = charges;
	}
	public double getTotaldistance() {
		return totaldistance;
	}
	public void setTotaldistance(double totaldistance) {
		this.totaldistance = totaldistance;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
