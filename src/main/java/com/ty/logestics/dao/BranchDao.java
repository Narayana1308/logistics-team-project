package com.ty.logestics.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.logestics.dto.Branch;
import com.ty.logestics.dto.Company;
import com.ty.logestics.repo.BranchRepo;

@Repository
public class BranchDao {
	@Autowired
	public BranchRepo branchRepo;
	@Autowired
	public CompanyDao companyDao;

	public Branch saveBranch(Branch branch, String cid) {
		Company company = companyDao.getCompanyById(cid);
		if (company != null) {
			branch.setCompany(company);
			return branchRepo.save(branch);
		} else {
			return null;
		}

	}

	public Branch updateBranch(int bid, Branch branch) {
		Branch branch2 = branchRepo.findById(bid).get();
		if (branch2 != null) {
			branch.setId(bid);
			branch.setCompany(branch2.getCompany());
			return branchRepo.save(branch);
		} else {
			return null;
		}

	}

	public Branch deleteBranch(int bid) {
		Branch branch = branchRepo.findById(bid).get();
		if (branch != null) {
			branchRepo.deleteById(bid);
			return branch;
		} else {
			return null;
		}
	}

	public Branch getBranchById(int bid) {
		if (branchRepo.findById(bid).isPresent()) {
			return branchRepo.findById(bid).get();
		} else {
			return null;
		}
	}

	public Branch getBranchByManagerName(String managerName) {

		return branchRepo.findByBranchManager(managerName);

	}

	public List<Branch> getAllBranches() {
		List<Branch> list=branchRepo.findAll();
		if(list!=null) {
			return list;
		}else {
		return null;
		}

	}
	
	public List<Branch> listOfBranch(String id){
		List<Branch> branchs=branchRepo.listOfBranch(id);
		if(branchs!=null) {
			return branchs;
		}else {
		return null;
		}
		
	}

}
