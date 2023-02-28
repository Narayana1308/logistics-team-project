package com.ty.logestics.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.logestics.dto.Order;
import com.ty.logestics.repo.OrderRepo;

@Repository
public class OrderDao {
	
	@Autowired
	private OrderRepo orderRepo;
	
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public Order updateOrder(int id,Order order) {
		if(orderRepo.findById(id).isPresent()) {
			order.setId(id);
			return orderRepo.save(order);
		} else {
			return null;
		}
	}
	
	public Order deleteOrder(int id) {
		if(orderRepo.findById(id).isPresent()) {
			Order order=orderRepo.findById(id).get();
			orderRepo.delete(order);
			return order;
		}else {
			return null;
		}
	}
	
	public Order getOrderById(int id) {
		
		return orderRepo.findById(id).get();
		
	}

}
