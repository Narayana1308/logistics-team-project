package com.ty.logestics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.logestics.dao.BranchDao;
import com.ty.logestics.dao.CompanyDao;
import com.ty.logestics.dto.Branch;
import com.ty.logestics.exception.CompanyIdNotFoundException;

import com.ty.logestics.dto.Company;

import com.ty.logestics.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao branchDao;
	@Autowired
	private CompanyDao companyDao;

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
			return null;
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		Branch branch = branchDao.deleteBranch(id);
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		if (branch != null) {
			structure.setMessage("Deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		} else {
			throw new CompanyIdNotFoundException();

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
			throw new CompanyIdNotFoundException();
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
			throw new CompanyIdNotFoundException();

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
			throw new CompanyIdNotFoundException();

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
		}
		else {
			return null;
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> getBranchByManager(String managerName) {
		ResponseStructure<Branch> structure = new ResponseStructure<>();
		Branch branch2 = branchDao.getBranchByManagerName(managerName);
		if (branch2 != null) {
			structure.setMessage(managerName);
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(branch2);
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		}
		else {
			return null;
		}
	}

}
