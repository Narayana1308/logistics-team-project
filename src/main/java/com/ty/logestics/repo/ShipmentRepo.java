package com.ty.logestics.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.logestics.dto.Shipment;

public interface ShipmentRepo  extends JpaRepository<Shipment, Integer>{

}
