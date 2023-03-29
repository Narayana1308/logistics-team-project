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
import com.ty.logestics.exception.CompanyIdNotFoundException;

import com.ty.logestics.dto.Company;
import com.ty.logestics.dto.Goods;
import com.ty.logestics.dto.Shipment;
import com.ty.logestics.exception.BranchIdNotFoundException;
import com.ty.logestics.exception.BranchManagerNotFoundException;

import com.ty.logestics.exception.ListEmptyException;
import com.ty.logestics.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private ShipmentDao shipmentDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, String cid) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Company company = companyDao.getCompanyById(cid);

		if (company != null) {
			Branch daoBranch = branchDao.saveBranch(branch, cid);
			structure.setMessage("Saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(daoBranch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);

		} else {
			throw new CompanyIdNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {

		List<Goods> goods = goodsDao.listOfGoods(id);
		if (goods != null) {
			for (Goods goods2 : goods) {
				List<Shipment> ship = shipmentDao.listShipment(goods2.getId());
				if (ship != null) {
					for (Shipment shipment : ship) {
						shipmentDao.deleteShipment(shipment.getId());
					}
				}
				goodsDao.deleteById(goods2.getId());
			}
		}

		Branch branch = branchDao.deleteBranch(id);
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (branch != null) {
			structure.setMessage("Deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {

			throw new BranchIdNotFoundException();

		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id, Branch branch) {
		Branch branch2 = branchDao.updateBranch(id, branch);
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (branch2 != null) {
			structure.setMessage("Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {

			throw new BranchIdNotFoundException();

		}
	}

	public ResponseEntity<ResponseStructure<Branch>> getById(int id) {
		Branch barnch2 = branchDao.getBranchById(id);

		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		if (barnch2 != null) {
			structure.setMessage("Successfully found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(barnch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFoundException();

		}
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id) {
		Branch barnch2 = branchDao.getBranchById(id);

		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		if (barnch2 != null) {
			structure.setMessage("Successfully found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(barnch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {

			throw new BranchIdNotFoundException();

		}
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranches() {
		List<Branch> branch2 = branchDao.getAllBranches();
		ResponseStructure<List<Branch>> structure = new ResponseStructure<List<Branch>>();
		if (branch2 != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);

		} else {
			throw new ListEmptyException();
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchByManager(String managerName) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Branch branch2 = branchDao.getBranchByManagerName(managerName);
		if (branch2 != null) {
			structure.setMessage("found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);

		} else {
			throw new BranchManagerNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Branch>>> listOfBranches(String id) {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<>();
		Company company = companyDao.getCompanyById(id);
		if (company != null) {
			List<Branch> list = branchDao.listOfBranch(id);
			if (list != null) {
				structure.setMessage("getting");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(list);
				return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
			} else {
				throw new ListEmptyException();
			}
		} else {
			throw new CompanyIdNotFoundException();
		}

	}
}
