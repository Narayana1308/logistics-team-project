package com.ty.logestics.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.logestics.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
