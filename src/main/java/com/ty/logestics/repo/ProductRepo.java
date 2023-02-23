package com.ty.logestics.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.logestics.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
