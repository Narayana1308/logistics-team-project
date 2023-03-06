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

import com.ty.logestics.dto.Product;
import com.ty.logestics.service.ProductService;
import com.ty.logestics.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@ApiOperation(value = "save the product ", notes = "Api is used save the product ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully created"),
			@ApiResponse(code = 404, message = "not found") })
	@PostMapping("/product")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {

		return service.saveProduct(product);
	}
	@ApiOperation(value = "delete the product ", notes = "Api is used delete the product  based on product id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully deleted"),
			@ApiResponse(code = 404, message = "not found") })

	@DeleteMapping("/product")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam int id) {

		return service.deleteProduct(id);
	}
	@ApiOperation(value = "get the product ", notes = "Api is used get the product  based on product id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),
			@ApiResponse(code = 404, message = "not found") })

	@GetMapping("/product")
	public ResponseEntity<ResponseStructure<Product>> getProduct(@RequestParam int id) {

		return service.getProductById(id);

	}
	@ApiOperation(value = "update the product ", notes = "Api is used update the product  based on product id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),
			@ApiResponse(code = 404, message = "not found") })

	@PutMapping("/product")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestParam int id,
			@RequestBody Product product) {

		return service.updateProduct(id, product);

	}

}
