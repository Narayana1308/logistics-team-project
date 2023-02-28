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
public class Company {
 
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_seq")
    @GenericGenerator(name = "comp_seq", strategy = "com.ty.logestics.dto.StringPrefixedSequenceIdGenerator",
            parameters = {
            @Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "50"),
            @Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "TYSS_"),
            @Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	private String name;
	private String gst;
	private String email;
	private long phone;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	
	
	
	
		
}
