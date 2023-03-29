package com.ty.logestics.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Company {
 

	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_seq")
    @GenericGenerator(name = "comp_seq", strategy = "com.ty.logestics.util.StringPreFixedIdSequenceGenerator",
            parameters = {
            @Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "TYSS_"),
            @Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	
	@NotNull(message="name should not be null")
	@NotBlank(message="name should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="name contains  characters only")
	private String name;
	
	@NotNull(message="GST should not be null")
	@NotBlank(message="GSt should not be blank")
	private String gst;
	
	@NotNull(message="email should not be null")
	@NotBlank(message="email should not be blank")
	@Email(regexp = "[a-zA-Z0-9]+[@][A-Za-z]*[.]com" ,message="Enter the proper Email id")
	private String email;
	
	@NotNull(message="phone should not be null")
	@NotBlank(message="phone should not be blank")
	@Pattern(regexp = "[6-9][0-9]{9}" ,message ="number contains 10 digits and starts with 6-9")
	private String phone;
	
	@NotNull(message="CEO name should not be null")
	@NotBlank(message="CEO should not be blank")
	@Pattern(regexp = "[a-zA-z]*" ,message ="name contails  characters only")
	private String ceo;
	

	
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
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	
	
	
	
	
		
}
