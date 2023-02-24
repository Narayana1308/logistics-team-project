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

	public User updateUser(int id, User user) {
		if (repo.findById(id).isPresent()) {
			user.setId(id);
			return repo.save(user);
		} else {
           return null;
		}
	}
	public User deleteUser(int id) {
		User user=repo.findById(id).get();
		if(user!=null) {
			repo.deleteById(id);
			return user;
		}else {
			return null;
		}
	}
	public User getUserById(int id) {
			return repo.findById(id).get();
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
		return repo.findByEmail(email);
	}

}
