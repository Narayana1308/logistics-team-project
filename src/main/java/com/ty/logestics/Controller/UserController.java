package com.ty.logestics.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.logestics.dto.User;
import com.ty.logestics.service.UserService;
import com.ty.logestics.util.ResponseStructure;

@RestController
public class UserController {
	@Autowired
	private UserService service;
    @PostMapping("/saveuser")
	public ResponseEntity<ResponseStructure<User>> save(@RequestBody User user) {
		return service.save(user);
	}

}
