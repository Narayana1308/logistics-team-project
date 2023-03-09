package com.ty.logestics.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="product name should not be null")
	@NotBlank(message="product name should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="product name contails  characters only")
	private String product_name;
	@NotNull(message="product type should not be null")
	@NotBlank(message="product type should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="product type contails  characters only")
	private String product_type;
	@Min(value=1,message="the product quality atleast one is required")
	private int quantity;
	@Min(value=1,message="the product weight atleast 1 kg ")
	@Max(value=25,message="the product weight not more than 25 kg")
	private int weight;
	@NotNull(message="brand should not be null")
	@NotBlank(message="brand should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="brand contails  characters only")
	private String brand;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	}
