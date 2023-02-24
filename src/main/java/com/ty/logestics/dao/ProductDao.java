package com.ty.logestics.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.logestics.dto.Product;
import com.ty.logestics.repo.ProductRepo;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepo repo;

	public Product saveProduct(Product product) {

		return repo.save(product);

	}

	public Product updateProduct(int id, Product product) {

		if (repo.findById(id).isPresent()) {
			product.setId(id);
			return repo.save(product);
		}

		else
			return null;

	}

	public Product deleteProduct(int id) {
		if (repo.findById(id).isPresent()) {
			Product product = repo.findById(id).get();
			repo.delete(product);
			return product;
		} else
			return null;
	}

	public Product getProductById(int id) {
		if (repo.findById(id).isPresent()) {
			Product product = repo.findById(id).get();
			return product;

		} else
			return null;
	}

	public List<Product> getAll() {
		return repo.findAll();

	}

}
