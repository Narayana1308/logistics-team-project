package com.ty.logestics.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.logestics.dto.Shipment;

public interface ShipmentRepo  extends JpaRepository<Shipment, Integer>{
	


}
