package com.ty.logestics.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.logestics.dto.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer> {

	@Query("select c from Branch c where c.branch_Manager=?1")
	public Branch findByBranchManager(String name);

}
