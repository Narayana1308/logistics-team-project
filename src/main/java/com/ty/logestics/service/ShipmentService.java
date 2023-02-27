package com.ty.logestics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.logestics.dao.GoodsDao;
import com.ty.logestics.dao.ShipmentDao;
import com.ty.logestics.dto.Goods;
import com.ty.logestics.dto.Shipment;
import com.ty.logestics.exception.IdNotFoundException;
import com.ty.logestics.util.ResponseStructure;

@Service
public class ShipmentService {

	@Autowired
	private GoodsDao dao;

	@Autowired
	private ShipmentDao sdao;

	public ResponseEntity<ResponseStructure<Shipment>> saveShipment(int id, Shipment shipment) {

		Goods goods = dao.getById(id);
		if (goods != null) {
			shipment.setGoods(goods);
		}
		ResponseStructure<Shipment> structure = new ResponseStructure<Shipment>();

		structure.setMessage("successfully saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(sdao.saveShipment(id, shipment));

		return new ResponseEntity<ResponseStructure<Shipment>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Shipment>> updateShipment(int id, Shipment shipment) {

		Shipment dbShipment = sdao.getById(id);

		if (dbShipment != null) {
			shipment.setGoods(dbShipment.getGoods());
			ResponseStructure<Shipment> structure = new ResponseStructure<Shipment>();

			structure.setMessage("successfully updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(sdao.updateShipment(id, shipment));

			return new ResponseEntity<ResponseStructure<Shipment>>(structure, HttpStatus.OK);

		} else
			throw new IdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<Shipment>> deleteShipment(int id) {
		Shipment shipment = sdao.getById(id);

		if (shipment != null) {
			ResponseStructure<Shipment> responseStructure = new ResponseStructure<Shipment>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(shipment);
			return new ResponseEntity<ResponseStructure<Shipment>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Shipment>> getShipment(int id) {
		Shipment shipment = sdao.getById(id);
		if (shipment != null) {
			ResponseStructure<Shipment> responseStructure = new ResponseStructure<Shipment>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(shipment);

			return new ResponseEntity<ResponseStructure<Shipment>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}
}
