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
import com.ty.logestics.dto.Orders;
import com.ty.logestics.service.OrderService;
import com.ty.logestics.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@ApiOperation(value = "save the order ", notes = "Api is used save the order based on the product id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully created"),
			@ApiResponse(code = 404, message = "not found") })
	
	@PostMapping("/order")
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(@RequestParam int pid ,@RequestBody Orders order){
		return service.saveOrder(pid, order);
	}
	@ApiOperation(value = "update the order ", notes = "Api is used update the order based on the order id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "not found") })
	
	@PutMapping("/order")
	public ResponseEntity<ResponseStructure<Orders>> updateOrder(@RequestParam int id ,@RequestBody Orders order){
		return service.updateOrder(id, order);
	}
	@ApiOperation(value = "get the order ", notes = "Api is used get the order based on id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),
			@ApiResponse(code = 404, message = "not found") })
	
	@GetMapping("/order")
	public ResponseEntity<ResponseStructure<Orders>> getOrder(@RequestParam int id ){
		return service.getOrder(id);
	}
	
	@ApiOperation(value = "delete the order ", notes = "Api is used delete the order based on id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully deleted"),
			@ApiResponse(code = 404, message = "not found") })
	@DeleteMapping("/order")
	public ResponseEntity<ResponseStructure<Orders>> deleteOrder(@RequestParam int id ){
		return service.deleteOrder(id);
	}
	@ApiOperation(value = "add product ", notes = "Api is used  to add product in an order ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully added"),
			@ApiResponse(code = 404, message = "not found") })
	@PutMapping("/addproduct")
	public ResponseEntity<ResponseStructure<Orders>> addProduct(@RequestParam int oid,@RequestParam int pid){
		return service.addProduct(pid, oid);
	}
}
