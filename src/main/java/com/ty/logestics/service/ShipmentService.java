package com.ty.logestics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.logestics.dao.BranchDao;
import com.ty.logestics.dao.CompanyDao;
import com.ty.logestics.dao.GoodsDao;
import com.ty.logestics.dao.ShipmentDao;
import com.ty.logestics.dto.Branch;
import com.ty.logestics.dto.Company;
import com.ty.logestics.dto.Goods;
import com.ty.logestics.dto.Shipment;
import com.ty.logestics.exception.CompanyIdNotFoundException;
import com.ty.logestics.exception.GoodsIdNotFoundException;
import com.ty.logestics.exception.ShipmentIdNotFoundException;

import com.ty.logestics.util.ResponseStructure;

@Service
public class ShipmentService {

	@Autowired
	private GoodsDao dao;
	@Autowired
	private BranchDao branchDao;

	@Autowired
	private ShipmentDao shipmentDao;

	@Autowired
	private GoodsDao goodsDao;

	@Autowired
	private CompanyDao companyDao;

	public ResponseEntity<ResponseStructure<Shipment>> saveShipment(int gid, Shipment shipment) {

		Goods goods = dao.getById(gid);
		if (goods != null) {
			shipment.setGoods(goods);

			ResponseStructure<Shipment> structure = new ResponseStructure<Shipment>();

			structure.setMessage("successfully saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(shipmentDao.saveShipment(gid, shipment));

			return new ResponseEntity<ResponseStructure<Shipment>>(structure, HttpStatus.CREATED);
		}

		else

			throw new GoodsIdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<Shipment>> updateShipment(int id, Shipment shipment, int bid) {

		Shipment dbShipment = shipmentDao.getById(id);
		Branch branch = branchDao.getBranchById(bid);

		if (dbShipment != null && branch != null) {
			Goods goods = dbShipment.getGoods();
			goods.setBranch(branch);
			shipment.setGoods(goods);
			ResponseStructure<Shipment> structure = new ResponseStructure<Shipment>();

			structure.setMessage("successfully updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(shipmentDao.updateShipment(id, shipment));

			return new ResponseEntity<ResponseStructure<Shipment>>(structure, HttpStatus.OK);

		} else

			throw new ShipmentIdNotFoundException();

	}

	public ResponseEntity<ResponseStructure<Shipment>> deleteShipment(int id) {
		List<Shipment> ship = shipmentDao.listShipment(id);
		if (ship != null) {
			for (Shipment shipment : ship) {
				shipmentDao.deleteShipment(shipment.getId());
			}
		}
		Shipment shipment = shipmentDao.deleteShipment(id);
		ResponseStructure<Shipment> structure = new ResponseStructure<>();
		if (shipment != null) {
			structure.setMessage("Deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(shipment);
			return new ResponseEntity<ResponseStructure<Shipment>>(structure, HttpStatus.OK);
		} else {

			throw new ShipmentIdNotFoundException();

		}

	}

	public ResponseEntity<ResponseStructure<Shipment>> getShipment(int id) {
		Shipment shipment = shipmentDao.getById(id);
		if (shipment != null) {
			ResponseStructure<Shipment> responseStructure = new ResponseStructure<Shipment>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(shipment);

			return new ResponseEntity<ResponseStructure<Shipment>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ShipmentIdNotFoundException();

		}
	}
}
