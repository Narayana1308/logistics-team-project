package com.ty.logestics.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.logestics.dto.Branch;


public interface BranchRepo extends JpaRepository<Branch, Integer> {

	@Query("select b from Branch b where b.branch_Manager=?1")
	public Branch findByBranchManager(String managerName);

}
