package com.ty.logestics.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.logestics.dto.Company;
import com.ty.logestics.repo.CompanyRepo;

@Repository
public class CompanyDao {

	@Autowired
	private CompanyRepo companyRepo;

	public Company saveCompany(Company company) {
		return companyRepo.save(company);
	}

	public Company updateCompany(String id, Company company) {
		Company company2=companyRepo.findByCompanyId(id);
		if (company2!=null) {
			company.setId(id);
			return companyRepo.save(company);
		} else {
			return null;
		}
	}

	public Company deleteCompany(int id) {
		if (companyRepo.findById(id).isPresent()) {
			Company company = companyRepo.findById(id).get();
			companyRepo.delete(company);
			return company;
		} else {
			return null;
		}

	}

	public Company getCompanyById(int id) {

		return companyRepo.findById(id).get();

	}

	public Company getCompanyByEmail(String email) {
		return companyRepo.findByEmail(email);
	}

	public Company getCompanyByCompanyName(String name) {
		return companyRepo.findByCompanyName(name);
	}

	public Company getCompanyByCeoName(String ceo) {
		return companyRepo.findByCeo(ceo);
	}

}
