package com.ty.logestics.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.logestics.dto.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
