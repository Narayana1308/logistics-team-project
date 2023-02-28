package com.ty.logestics.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ty.logestics.dto.Order;
import com.ty.logestics.service.OrderService;
import com.ty.logestics.util.ResponseStructure;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/order")
	public ResponseEntity<ResponseStructure<Order>> saveOrder(@RequestParam int pid ,@RequestBody Order order){
		return service.saveOrder(pid, order);
	}
	
	@PutMapping("/order")
	public ResponseEntity<ResponseStructure<Order>> updateOrder(@RequestParam int id ,@RequestBody Order order){
		return service.updateOrder(id, order);
	}
	
	@GetMapping("/order")
	public ResponseEntity<ResponseStructure<Order>> getOrder(@RequestParam int id ){
		return service.getOrder(id);
	}
	
	@DeleteMapping("/order")
	public ResponseEntity<ResponseStructure<Order>> deleteOrder(@RequestParam int id ){
		return service.deleteOrder(id);
	}
}
