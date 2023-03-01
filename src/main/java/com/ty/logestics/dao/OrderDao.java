package com.ty.logestics.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.logestics.dto.Orders;
import com.ty.logestics.repo.OrderRepo;

@Repository
public class OrderDao {
	
	@Autowired
	private OrderRepo orderRepo;
	
	public Orders saveOrder(Orders order) {
		return orderRepo.save(order);
	}
	
	public Orders updateOrder(int id,Orders order) {
		if(orderRepo.findById(id).isPresent()) {
			order.setId(id);
			return orderRepo.save(order);
		} else {
			return null;
		}
	}
	
	public Orders deleteOrder(int id) {
		if(orderRepo.findById(id).isPresent()) {
			Orders order=orderRepo.findById(id).get();
			orderRepo.delete(order);
			return order;
		}else {
			return null;
		}
	}
	
	public Orders getOrderById(int id) {
		if(orderRepo.findById(id).isPresent()) {
			Orders orders=orderRepo.findById(id).get();
		
		return orders;
		}else {
			return null;
		}
		
	}

}
