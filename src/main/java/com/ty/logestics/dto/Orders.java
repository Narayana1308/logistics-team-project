package com.ty.logestics.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@NotNull(message="ordertype  should not be null")
	@NotBlank(message="ordertype should not be blank")
	@Pattern(regexp = "[a-zA-z]+" ,message ="ordertype contains  characters only")
	
	private String oderType;
	
	@NotNull(message="address  should not be null")
	@NotBlank(message="address should not be blank")
	@Pattern(regexp = "[a-zA-z/.0-9]+" ,message ="address contains  characters and numbers only")
	private String to_Address;
	
	@NotNull(message="address  should not be null")
	@NotBlank(message="address should not be blank")
	@Pattern(regexp = "[a-zA-z/.0-9]+" ,message ="address contains  characters and numbers only")
	private String from_Address;
	
	@NotNull(message="charges  should not be null")
	@NotBlank(message="charges should not be blank")
	@Pattern(regexp = "[0-9/.]+" ,message ="charges contains  numbers only")
	private String charges;
	
	@NotNull(message="distance  should not be null")
	@NotBlank(message="distance should not be blank")
	@Pattern(regexp = "[0-9/.]+" ,message ="distance contains  numbers only")
	private String totaldistance;
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
	public String getCharges() {
		return charges;
	}
	public void setCharges(String charges) {
		this.charges = charges;
	}
	public String getTotaldistance() {
		return totaldistance;
	}
	public void setTotaldistance(String totaldistance) {
		this.totaldistance = totaldistance;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
