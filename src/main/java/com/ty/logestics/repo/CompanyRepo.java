package com.ty.logestics.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.logestics.dto.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
	
	@Query("select c from Company c where c.email=?1")
	public Company findByEmail(String email);
	
	@Query("select c from Company c where c.ceo=?1")
	public Company findByCeo(String ceo);
	
	@Query("select c from Company c where c.name=?1")
	public Company findByCompanyName(String name);
	
	@Query("select c from Company c where c.id=?1")
	public Company findByCompanyId(String id);
}
