package com.ty.logestics.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.logestics.dto.Branch;


public interface BranchRepo extends JpaRepository<Branch, Integer> {

	@Query("select b from Branch b where b.branch_Manager=?1")
	public Branch findByBranchManager(String managerName);
	@Query("select b from Branch b where b.company.id=?1")
	public List<Branch> listOfBranch(String id);

}
