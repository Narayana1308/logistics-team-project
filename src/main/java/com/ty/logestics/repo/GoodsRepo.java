package com.ty.logestics.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ty.logestics.dto.Goods;

public interface GoodsRepo extends JpaRepository<Goods	, Integer>{
	
	@Query("select g from Goods g where g.branch.id=?1")
	public List<Goods> listOfGoods(int id);
	@Query("select g from Goods g where g.order.id=?1")
	public Goods getGoodsByOrderId(int id);

}
