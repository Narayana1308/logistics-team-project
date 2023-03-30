package com.ty.logestics.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.logestics.dto.Goods;
import com.ty.logestics.dto.Shipment;

public interface ShipmentRepo  extends JpaRepository<Shipment, Integer>{

	@Query("select s from Shipment s where s.goods.id=?1")
	public List<Shipment> listOfShipment(int id);
	@Query("select ship from Shipment ship where ship.goods.id=?1")
	public Shipment getShipmentByGoodsId(int gid);


}
