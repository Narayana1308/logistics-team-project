package com.ty.logestics.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	
	

}
