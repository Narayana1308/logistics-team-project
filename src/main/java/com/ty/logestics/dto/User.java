package com.ty.logestics.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String name;
	private String email;
	private String password;
	private String role;
	private long phone;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	

	
}
