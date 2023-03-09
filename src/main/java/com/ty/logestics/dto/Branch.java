package com.ty.logestics.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="branch should not be null")
	@NotBlank(message="branch should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="branch name contails only characters")
	private String branch_name;
	
	@NotNull(message="email should not be null")
	@NotBlank(message="email should not be blank")
	@Email(regexp = "[a-zA-Z0-9][a-zA-Z0-9_.]*@gmail[.]com" ,message="Enter the proper Email id")
	private String email;
	
	@NotNull(message="password should not be null")
	@NotBlank(message="password should not be blank")
	@Pattern(regexp = "[a-zA-Z0-9]*[#&$]+",message="make password as strong ex: abc123&")
	private String password;
	
	@NotNull(message="phone should not be null")
	@NotBlank(message="phone should not be blank")
	@Pattern(regexp = "[6-9][0-9]{9}" ,message ="number should contains 10 digits and starts with 6-9")
	private String phone;
	
	@NotNull(message="branch_manager should not be null")
	@NotBlank(message="branch_manager should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="branch_manager name contails only characters")
	private String branch_Manager;
	@ManyToOne
	private Company company;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBranch_Manager() {
		return branch_Manager;
	}
	public void setBranch_Manager(String branch_Manager) {
		this.branch_Manager = branch_Manager;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	}
