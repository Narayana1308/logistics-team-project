package com.ty.logestics.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String oderType;
	private String to_Address;
	private String from_Address;
	private double charges;
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
