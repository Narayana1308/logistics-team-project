package com.ty.logestics.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ty.logestics.dto.Goods;

public interface GoodsRepo extends JpaRepository<Goods	, Integer>{
	
	@Query("select g from Goods g where g.branch.id=?1")
	public List<Goods> listOfGoods(int id);
<<<<<<< HEAD
	@Query("select g from Goods g where g.order.id=?1")
	public Goods getGoodsByOrderId(int id);
=======
	
>>>>>>> 5e676bfb8bfd402cc9ed45c9c488f3c2f6c255a7

}
