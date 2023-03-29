package com.ty.logestics.dao;

import java.util.List;

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
		
		if (repo.findById(id).isPresent()) {
			Goods goods2=repo.findById(id).get();
			goods.setId(id);
			goods.setBranch(goods2.getBranch());
			goods.setOrder(goods2.getOrder());
			goods.setUser(goods2.getUser());
			return repo.save(goods);
		} else {
			return null;
		}
	}

	public Goods deleteById(int id) {
		
		if (repo.findById(id).isPresent()) {
			Goods goods = repo.findById(id).get();
			repo.deleteById(id);
			return goods;
		} else {
			return null;
		}
	}

	public Goods getById(int id) {
		
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		return null;
	}

	public List<Goods> listOfGoods(int id) {
		// TODO Auto-generated method stub
		List<Goods> list=repo.listOfGoods(id);
		if(list!=null) {
		return list;
		}else {
			return null;
		}
	}

}
