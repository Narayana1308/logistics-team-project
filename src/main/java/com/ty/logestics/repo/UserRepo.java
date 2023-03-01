package com.ty.logestics.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.logestics.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("select user from User user where user.email=?1")
	public User findByEmail(String email);
	@Query("select user from User user where user.id=?1")
	public User findByUserId(String id);
//	@Query("delete user from User user where user.id=?1")
//	public User deleteByid(String id);

}
