package com.ty.logestics.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.logestics.dto.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer>{

}
