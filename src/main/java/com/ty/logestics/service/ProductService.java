package com.ty.logestics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.logestics.dao.ProductDao;
import com.ty.logestics.dto.Product;
import com.ty.logestics.exception.IdNotFoundException;
import com.ty.logestics.exception.ProductIdNotFoundException;
import com.ty.logestics.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {

		ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
		responseStructure.setMessage("successfully saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveProduct(product));

		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(int id, Product product) {

		Product daoProduct = dao.updateProduct(id, product);
		if (daoProduct != null) {
			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
			responseStructure.setMessage("successfully updated");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoProduct);

			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ProductIdNotFoundException("Given ProductId Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id) {
		Product daoProduct = dao.deleteProduct(id);
		if (daoProduct != null) {
			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
			responseStructure.setMessage("successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(daoProduct);

			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ProductIdNotFoundException("Given ProductId Not Found");

		}
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		Product daoProduct = dao.getProductById(id);
		if (daoProduct != null) {
			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>();
			responseStructure.setMessage("Found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(daoProduct);

			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ProductIdNotFoundException("Given ProductId Not Found");

		}
	}

}
