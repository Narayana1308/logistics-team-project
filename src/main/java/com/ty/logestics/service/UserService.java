package com.ty.logestics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.logestics.dao.UserDao;
import com.ty.logestics.dto.User;
import com.ty.logestics.exception.IdNotFoundException;
import com.ty.logestics.exception.InvalidPasswordException;
import com.ty.logestics.exception.UserEmailNotFoundException;
import com.ty.logestics.exception.UserIdNotFoundException;
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

	public ResponseEntity<ResponseStructure<User>> updateUser(String u_id, User user) {
		User user2 = dao.getUserById(u_id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (user2 != null) {
			structure.setMessage("updated succesfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateUser(u_id, user));
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<User>> loginUser(String email, String password)  {
		User user = dao.getUserByEmail(email);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (user != null) {
			if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
				structure.setMessage("Logged in succesfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(user);
				return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
			} else {
				throw new InvalidPasswordException();
			}
		} else {
			throw new UserEmailNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(String id) {
		User user = dao.getUserById(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (user != null) {
			structure.setMessage("Successfully found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		} else {
			throw new UserIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<User>> deleteUserById(String id) {
		User user = dao.getUserById(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (user != null) {
			structure.setMessage("Successfully deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteUser(id));
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<User>> getUserByEmail(String email) {
		User user = dao.getUserByEmail(email);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (user != null) {
			structure.setMessage("Successfully found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		} else {
			throw new UserEmailNotFoundException();
		}
	}

}
