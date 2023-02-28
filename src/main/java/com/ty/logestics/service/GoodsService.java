package com.ty.logestics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.logestics.dao.BranchDao;
import com.ty.logestics.dao.GoodsDao;
import com.ty.logestics.dao.OrderDao;
import com.ty.logestics.dao.UserDao;
import com.ty.logestics.dto.Branch;
import com.ty.logestics.dto.Goods;
import com.ty.logestics.dto.Orders;
import com.ty.logestics.dto.User;
import com.ty.logestics.util.ResponseStructure;

@Service
public class GoodsService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private GoodsDao goodsDao;
	
	public ResponseEntity<ResponseStructure<Goods>> saveGoods(int oid,int uid,int bid,Goods goods){
		Orders order=orderDao.getOrderById(oid);
		Branch branch=branchDao.getBranchById(bid);
		User user=userDao.getUserById(uid);
		ResponseStructure<Goods> structure=new ResponseStructure<>();
		if(order!=null && branch !=null && user!=null) {
			structure.setMessage("successfully saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(goodsDao.saveGoods(goods));
			return new ResponseEntity<ResponseStructure<Goods>>(structure,HttpStatus.CREATED);
		}
		else {
			return null;
		}				
	}
	public ResponseEntity<ResponseStructure<Goods>> updateGoods(int gid,Goods goods){
		Goods goods2=goodsDao.getById(gid);
		ResponseStructure<Goods> structure=new ResponseStructure<>();
		if(goods2!=null) {
			structure.setMessage("updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(goodsDao.updateGoods(gid, goods2));
			return new ResponseEntity<ResponseStructure<Goods>>(structure,HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	public ResponseEntity<ResponseStructure<Goods>> getGoodsById(int gid){
		Goods goods2=goodsDao.getById(gid);
		ResponseStructure<Goods> structure=new ResponseStructure<>();
		if(goods2!=null) {
			structure.setMessage("successfully found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(goods2);
			return new ResponseEntity<ResponseStructure<Goods>>(structure,HttpStatus.FOUND);
		}
		else {
			return null;
		}
	}
	public ResponseEntity<ResponseStructure<Goods>> deleteGoodsById(int id){
		Goods goods=goodsDao.getById(id);
		ResponseStructure<Goods> structure=new ResponseStructure<>();
		if(goods!=null) {
			structure.setMessage("deleted successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(goods);
			return new ResponseEntity<ResponseStructure<Goods>>(structure,HttpStatus.OK);	
		}
		else {
			return null;
		}
	}

}
