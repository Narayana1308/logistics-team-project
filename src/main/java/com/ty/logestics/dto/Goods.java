package com.ty.logestics.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="goods name should not be null")
	@NotBlank(message="goods name should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="goods name should contain only characters")
	private String name;
	
	@NotNull(message="Description should not be null")
	@NotBlank(message="Description should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="Description should contain only characters")
	private String description;
	
	@NotNull(message="Manufacture name should not be null")
	@NotBlank(message="Manufacture name should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="Manufacture name should contain only characters")
	private String manufacture;
	
	@Min(value=100,message="Minimum cost of the goods should be 100 rupees")
	private double cost;
	
	@NotNull(message="email should not be null")
	@NotBlank(message="email should not be blank")
	@Email(regexp = "[a-zA-Z0-9][a-zA-Z0-9_.]*@gmail[.]com" ,message="Enter the proper Email id")
	private String email;
	
	@ManyToOne
	private  User user;
	@ManyToOne
	private Branch branch;
	@OneToOne
	private Orders order;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	}
