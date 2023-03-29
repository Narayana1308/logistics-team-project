package com.ty.logestics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
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
import com.ty.logestics.util.ResponseStructure;

@Service
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private ShipmentDao shipmentDao;

	public ResponseEntity<ResponseStructure<Company>> saveCompany(Company company) {

		ResponseStructure<Company> structure = new ResponseStructure<>();
		structure.setMessage("Successfully saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(companyDao.saveCompany(company));
		return new ResponseEntity<ResponseStructure<Company>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Company>> updateCompany(String id, Company company) {
		Company daoCompany = companyDao.updateCompany(id, company);
		if (daoCompany != null) {
			ResponseStructure<Company> structure = new ResponseStructure<>();
			structure.setMessage("Successfully updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoCompany);
			return new ResponseEntity<ResponseStructure<Company>>(structure, HttpStatus.OK);
		} else {
			throw new CompanyIdNotFoundException("Id not found for given company ");
		}
	}

	public ResponseEntity<ResponseStructure<Company>> getCompanyId(String id) {
		ResponseStructure<Company> structure = new ResponseStructure<>();
		Company company2 = companyDao.getCompanyById(id);
		if (company2 != null) {

			structure.setMessage("Successfully found Company");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(company2);
			return new ResponseEntity<ResponseStructure<Company>>(structure, HttpStatus.FOUND);

		} else {
			throw new CompanyIdNotFoundException("Id not found for given company ");
		}
	}

	public ResponseEntity<ResponseStructure<Company>> deleteCompanyId(String id) {
		List<Branch> list = branchDao.listOfBranch(id);
		for (Branch branch : list) {

			List<Goods> goods = goodsDao.listOfGoods(branch.getId());
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
			branchDao.deleteBranch(branch.getId());
			
		}
		Company company = companyDao.deleteCompany(id);
		if (company != null) {
			ResponseStructure<Company> structure = new ResponseStructure<>();
			structure.setMessage("Successfully deleted Company");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(company);
			return new ResponseEntity<ResponseStructure<Company>>(structure, HttpStatus.OK);
		} else {
			throw new CompanyIdNotFoundException("Id not found for given company ");
		}
	}

	public ResponseEntity<ResponseStructure<Company>> getCompanyEmail(String email) {
		ResponseStructure<Company> structure = new ResponseStructure<>();
		Company company = companyDao.getCompanyByEmail(email);
		if (company != null) {
			structure.setMessage("Successfully found Company by email");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(company);
			return new ResponseEntity<ResponseStructure<Company>>(structure, HttpStatus.FOUND);
		} else {
			throw new CompanyIdNotFoundException("company does not exist of this given email id");
		}
	}

	public ResponseEntity<ResponseStructure<Company>> getCompanyCeo(String ceo) {
		ResponseStructure<Company> structure = new ResponseStructure<>();
		Company company = companyDao.getCompanyByCeoName(ceo);
		if (company != null) {
			structure.setMessage("Successfully found Company by Ceo Name");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(company);
			return new ResponseEntity<ResponseStructure<Company>>(structure, HttpStatus.FOUND);
		} else {
			throw new CompanyIdNotFoundException("company does not exist of this given ceo name");
		}

	}

	public ResponseEntity<ResponseStructure<Company>> getCompanyName(String name) {
		ResponseStructure<Company> structure = new ResponseStructure<>();
		Company company = companyDao.getCompanyByCompanyName(name);
		if (company != null) {
			structure.setMessage("Successfully found Company by  Name");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(company);
			return new ResponseEntity<ResponseStructure<Company>>(structure, HttpStatus.FOUND);
		} else {
			throw new CompanyIdNotFoundException("company does not exist of this given  name");
		}
	}

}
