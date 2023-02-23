package com.ty.logestics.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.logestics.dto.Goods;

public interface GoodsRepo extends JpaRepository<Goods	, Integer>{
	
	

}
