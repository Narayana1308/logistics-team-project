package com.ty.logestics.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.logestics.dto.Goods;
import com.ty.logestics.dto.Shipment;
import com.ty.logestics.repo.ShipmentRepo;

@Repository
public class ShipmentDao {

	@Autowired
	private ShipmentRepo repo;

	@Autowired
	private GoodsDao dao;

	public Shipment saveShipment(int gid, Shipment shipment) {

		Goods goods = dao.getById(gid);
		if (goods != null) {

			shipment.setGoods(goods);
		}

		return repo.save(shipment);

	}

	public Shipment updateShipment(int sid, Shipment shipment) {
		if (repo.findById(sid).isPresent()) {
			Shipment dbShipment = repo.findById(sid).get();
			shipment.setId(sid);
			shipment.setGoods(dbShipment.getGoods());

			return repo.save(shipment);
		}
		return null;

	}

	public Shipment deleteShipment(int id) {

		if (repo.findById(id).isPresent()) {

			Shipment shipment = repo.findById(id).get();

			repo.delete(shipment);

			return shipment;

		}

		else
			return null;

	}

	public Shipment getById(int id) {

		if (repo.findById(id).isPresent()) {

			Shipment shipment = repo.findById(id).get();
			return shipment;

		} else
			return null;

	}

	public List<Shipment> listShipment(int id) {
		List<Shipment> list = repo.listOfShipment(id);
		if (list != null) {
			return list;
		} else {
			return null;
		}
	}

	public Shipment getShipmentByGoodsId(int gid) {
		Shipment shipment=repo.getShipmentByGoodsId(gid);
		if(shipment!=null) {
			return shipment;
		}else {
			
			return null;
		}
	}
}
