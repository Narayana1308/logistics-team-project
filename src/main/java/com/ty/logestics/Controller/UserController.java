package com.ty.logestics.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user,@RequestParam String id){
    	return service.updateUser(id, user);
    }
    @GetMapping("/login")
    public ResponseEntity<ResponseStructure<User>> login(@RequestParam String email ,@RequestParam String password ){
    	return service.loginUser(email, password);
    }
    @GetMapping("/getuser")
    public ResponseEntity<ResponseStructure<User>> getuser(@RequestParam String id){
    	return service.getUserById(id);
    }
    @GetMapping("/getuserbyemail")
    public ResponseEntity<ResponseStructure<User>> getUserByEmail(@RequestParam String email){
    	return service.getUserByEmail(email);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseStructure<User>> delete(@RequestParam String id){
    	return service.deleteUserById(id);
    }

}
