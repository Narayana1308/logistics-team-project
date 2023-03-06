package com.ty.logestics.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.logestics.dto.User;
import com.ty.logestics.repo.UserRepo;

@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User updateUser(String id, User user) {
		
		User user2=repo.findByUserId(id);
		if (user2!=null) {
			user.setId(id);
			return repo.save(user);
		} else {
           return null;
		}
	}
	public User deleteUser(String id) {
		User user=repo.findByUserId(id);
		if(user!=null) {
			repo.delete(user);
			return user;
		}else {
			return null;
		}
	}
	public User getUserById(String id) {
			return repo.findByUserId(id);
	}
	public User loginUser(String email) {
		User user=repo.findByEmail(email);
		if(user!=null) {
			return user;
		}else {
			return null;
		}
	}
	public User getUserByEmail(String email) {
		User user=repo.findByEmail(email);
		if(user!=null) {
			return user;
		}
		return null;
	}

}
