package com.ty.logestics.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.logestics.dto.Goods;
import com.ty.logestics.dto.User;
import com.ty.logestics.repo.GoodsRepo;
import com.ty.logestics.repo.UserRepo;

@Repository
public class GoodsDao {
	@Autowired
	private GoodsRepo repo;

	public Goods saveUser(Goods goods) {
		return repo.save(goods);
	}
	
	

}
