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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@ApiOperation(value = "Save the user", notes = "Api is used Save the user ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully created")})
	@PostMapping("/saveuser")
	public ResponseEntity<ResponseStructure<User>> save(@RequestBody User user) {
		return service.save(user);
	}

	@ApiOperation(value = "update the user", notes = "Api is used update the user basedc on the user id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully updated"),@ApiResponse(code=404,message="not found" )})
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user, @RequestParam String id) {
		return service.updateUser(id, user);
	}

	
	@ApiOperation(value = "login the user", notes = "Api is used login  the user based on email and password ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully login"),@ApiResponse(code=404,message="not fopund")})
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<User>> login(@RequestParam String email, @RequestParam String password) {
		return service.loginUser(email, password);
	}

	
	@ApiOperation(value = "get the user details", notes = "Api is used get the user details based on user id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),@ApiResponse(code=404,message="not found")})
	@GetMapping("/getuser")
	public ResponseEntity<ResponseStructure<User>> getuser(@RequestParam String id) {
		return service.getUserById(id);
	}

	@ApiOperation(value = "get  the user details based on email", notes = "Api is used get the user  based on email")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully found"),@ApiResponse(code=404,message="not found")})
	@GetMapping("/getuserbyemail")
	public ResponseEntity<ResponseStructure<User>> getUserByEmail(@RequestParam String email) {
		return service.getUserByEmail(email);
	}


	@ApiOperation(value = "delete  the user details", notes = "Api is used delete the user  based on id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "successfully deleted"),@ApiResponse(code=404,message="not found")})
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<User>> delete(@RequestParam String id) {
		return service.deleteUserById(id);
	}

}
