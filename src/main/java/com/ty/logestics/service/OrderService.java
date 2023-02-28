package com.ty.logestics.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.logestics.dao.OrderDao;
import com.ty.logestics.dao.ProductDao;
import com.ty.logestics.dto.Order;
import com.ty.logestics.dto.Product;
import com.ty.logestics.exception.IdNotFoundException;
import com.ty.logestics.util.ResponseStructure;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductDao productDao;
	
	public ResponseEntity<ResponseStructure<Order>> saveOrder(int pid,Order order){
		ResponseStructure<Order> structure=new ResponseStructure<>();
		List<Product> products=new ArrayList<>();
		Product product=productDao.getProductById(pid);
		products.add(product);
		if(products!=null) {
			order.setProducts(products);
			Order order2=orderDao.saveOrder(order);
			
			structure.setMessage("successfully saved Order");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(order2);
			
			return new ResponseEntity<ResponseStructure<Order>> (structure,HttpStatus.CREATED);
			
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Order>> updateOrder(int oid,Order order){
	
		Order daoOrder=orderDao.getOrderById(oid);
		if(daoOrder!=null) {
		//	order.setId(daoOrder.getId());
			order.setProducts(daoOrder.getProducts());
			ResponseStructure<Order> structure=new ResponseStructure<>();
			structure.setMessage("successfully updated Order");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(orderDao.updateOrder(oid, order));
			
			return new ResponseEntity<ResponseStructure<Order>> (structure,HttpStatus.OK);
			
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Order>> getOrder(int oid){
		Order order=orderDao.getOrderById(oid);
		if(order!=null) {
			ResponseStructure<Order> structure=new ResponseStructure<>();
			structure.setMessage("successfully fetched Order");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(order);
			return new ResponseEntity<ResponseStructure<Order>> (structure,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<Order>> deleteOrder(int oid){
		Order order=orderDao.deleteOrder(oid);
		if(order!=null) {
			ResponseStructure<Order> structure=new ResponseStructure<>();
			structure.setMessage("successfully deleted Order");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(order);
			
			return new ResponseEntity<ResponseStructure<Order>> (structure,HttpStatus.OK);
			
		}else {
			throw new IdNotFoundException();
		}
	}

}