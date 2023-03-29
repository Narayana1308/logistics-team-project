package com.ty.logestics.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


import com.ty.logestics.util.StringPreFixedIdSequenceGenerator;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "user_id")
	@GenericGenerator(name =  "user_id",strategy = "com.ty.logestics.util.StringPreFixedIdSequenceGenerator",parameters = {
			@Parameter(name=StringPreFixedIdSequenceGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER,value = "user_"),
			@Parameter(name=StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER,value = "%05d")
	})
	private String id;
	@NotNull(message="user name should not be null")
	@NotBlank(message="name should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="name contails  characters only")
	private String name;
	@NotNull(message="email should not be null")
	@NotBlank(message="email should not be blank")
	@Email(regexp = "[a-zA-Z0-9][a-zA-Z0-9_.]*@gmail[.]com" ,message="Enter the proper Email id")
	private String email;
	@NotNull(message="password should not be null")
	@NotBlank(message="password should not be blank")
	//@Pattern(regexp = "[a-zA-Z0-9]*[#&$]+",message="make password as strong ex: abc123&")
	private String password;
	@NotNull(message="role should not be null")
	@NotBlank(message="role should not be blank")
	@Pattern(regexp = "[a-zA-Z]*" ,message ="role contails  characters only")
	private String role;
	
	@NotNull(message="phone should not be null")
	@NotBlank(message="phone should not be blank")
	@Pattern(regexp = "[6-9][0-9]{9}" ,message ="number contaims 10 digits and starts with 6-9")
	private String phone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	
}
