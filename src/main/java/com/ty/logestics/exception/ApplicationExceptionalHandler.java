package com.ty.logestics.exception;

import java.util.NoSuchElementException;

import javax.management.ListenerNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.logestics.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionalHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CompanyIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(CompanyIdNotFoundException ex) {
		ResponseStructure<String> structre = new ResponseStructure<String>();
		structre.setMessage(ex.getMessage());
		structre.setStatus(HttpStatus.NOT_FOUND.value());
		structre.setData("no company for given id");
		return new ResponseEntity<ResponseStructure<String>>(structre, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> userIdNoTFound(UserIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("userid not found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(UserEmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> userEmailNoTFound(UserEmailNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("user email not found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ResponseStructure<String>> invalidPasssword(InvalidPasswordException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("invalid password");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(GoodsIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idnotfound(GoodsIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("id not found ");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(ShipmentIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> shipmentId(ShipmentIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		structure.setData(" shipment id not found ");

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ResponseStructure<String>> dataViolation(DataIntegrityViolationException exception) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("bad request");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Data integrity violation exception");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(BranchIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> branchIdNotFound(BranchIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("branch Id not found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BranchManagerNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> branchManagerNotFound(BranchManagerNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("branch manager not found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ListEmptyException.class)
	public ResponseEntity<ResponseStructure<String>> listNotFound(ListEmptyException ex){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("branches list not found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

}
