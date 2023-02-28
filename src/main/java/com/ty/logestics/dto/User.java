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

	
}
