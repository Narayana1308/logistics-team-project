package com.ty.logestics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.logestics.dao.CompanyDao;
import com.ty.logestics.dto.Company;
import com.ty.logestics.exception.IdNotFoundException;
import com.ty.logestics.util.ResponseStructure;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	public ResponseEntity<ResponseStructure<Company>> saveCompany(Company company){
		
		ResponseStructure<Company> structure=new ResponseStructure<>();
		structure.setMessage("Successfully saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(companyDao.saveCompany(company));
		return new ResponseEntity<ResponseStructure<Company>> (structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Company>> updateCompany(String id,Company company){
		Company daoCompany=companyDao.updateCompany(id, company);
		if(daoCompany!=null) {
			ResponseStructure<Company> structure=new ResponseStructure<>();
			structure.setMessage("Successfully updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoCompany);
			return new ResponseEntity<ResponseStructure<Company>> (structure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Id not found for given company ");
		}
	}
	
	public ResponseEntity<ResponseStructure<Company>> getCompanyId(int id){
		ResponseStructure<Company> structure=new ResponseStructure<>();
		Company company2=companyDao.getCompanyById(id);
		if(company2!=null) {
			
			structure.setMessage("Successfully found Company");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(company2);
			return new ResponseEntity<ResponseStructure<Company>> (structure,HttpStatus.FOUND);	
			
		} else {
			throw new IdNotFoundException("Id not found for given company ");
		}
	}
	
	public ResponseEntity<ResponseStructure<Company>> deleteCompanyId(int id){
		Company company=companyDao.deleteCompany(id);
		if(company!=null) {
			ResponseStructure<Company> structure=new ResponseStructure<>();
			structure.setMessage("Successfully deleted Company");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(company);
			return new ResponseEntity<ResponseStructure<Company>> (structure,HttpStatus.OK);		
		} else {
			throw new IdNotFoundException("Id not found for given company ");
		}
	}

}
