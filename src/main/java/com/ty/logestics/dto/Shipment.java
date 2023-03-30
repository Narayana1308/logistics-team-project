package com.ty.logestics.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Shipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "address should not be null")
	@NotBlank(message = "address should not be blank")
	@Pattern(regexp = "[a-zA-z]*", message = "address contails  characters only")
	private String address;
	@NotNull(message = "manager name should not be null")
	@NotBlank(message = "manager name should not be blank")
	@Pattern(regexp = "[a-zA-z]*", message = " manager name contails  characters only")
	private String manager_name;
	@NotNull(message = "phone should not be null")
	@NotBlank(message = "phone should not be blank")
	@Pattern(regexp = "[6-9][0-9]{9}", message = "number contaims 10 digits and starts with 6-9")
	private String phone;

	@ManyToOne
	private Goods goods;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}
