package com.ty.logestics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.logestics.dao.UserDao;
import com.ty.logestics.dto.User;
import com.ty.logestics.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> save(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);

	}

}
