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

	public Goods saveGoods(Goods goods) {
		return repo.save(goods);
	}

	public Goods updateGoods(int id, Goods goods) {
		Goods goods2=repo.findById(id).get();
		if (goods2!=null) {
			goods.setId(id);
			goods.setBranch(goods2.getBranch());
			goods.setOrder(goods2.getOrder());
			return repo.save(goods);
		} else {
			return null;
		}
	}

	public Goods deleteById(int id) {
		Goods goods = repo.findById(id).get();
		if (goods != null) {
			repo.deleteById(id);
			return goods;
		} else {
			return null;
		}
	}

	public Goods getById(int id) {
		return repo.findById(id).get();
	}

}
