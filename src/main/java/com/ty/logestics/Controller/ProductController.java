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

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/product")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {

		return service.saveProduct(product);
	}

	@DeleteMapping("/product")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam int id) {

		return service.deleteProduct(id);
	}

	@GetMapping("/product")
	public ResponseEntity<ResponseStructure<Product>> getProduct(@RequestParam int id) {

		return service.getProductById(id);

	}

	@PutMapping("/product")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestParam int id,
			@RequestBody Product product) {

		return service.updateProduct(id, product);

	}

}
