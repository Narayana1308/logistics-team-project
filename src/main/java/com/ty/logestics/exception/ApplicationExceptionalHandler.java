package com.ty.logestics.exception;

import java.util.List;
import java.util.NoSuchElementException;

import javax.management.ListenerNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.logestics.util.ResponseStructure;



@ControllerAdvice
public class ApplicationExceptionalHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CompanyIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(CompanyIdNotFoundException ex){
		ResponseStructure<String> structre= new ResponseStructure<String>();
		structre.setMessage(ex.getMessage());
		structre.setStatus(HttpStatus.NOT_FOUND.value());
		structre.setData("no company for given id");
		return new ResponseEntity<ResponseStructure<String>> (structre, HttpStatus.NOT_FOUND);
	
	}
	
//	@ExceptionHandler(NoSuchElementException.class)
//	public ResponseEntity<ResponseStructure<String>> noSuchElementExceptionHandler(NoSuchElementException ex){
//		ResponseStructure<String> structure=new ResponseStructure<String>();
//		structure.setMessage(ex.getMessage());
//		structure.setStatus(HttpStatus.NOT_FOUND.value());
//		structure.setData("no company for given id");
//		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
//		
//	}
	
	@ExceptionHandler(OrderIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> orderIdNotFoundExceptionalHandler(OrderIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		structure.setData("no Order found for given id");
		return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);

		

	}
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> userIdNoTFound(UserIdNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("userid not found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(UserEmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> userEmailNoTFound(UserEmailNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("user email not found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
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
	public ResponseEntity<ResponseStructure<String>> listNotFound(ListenerNotFoundException ex){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("branches list not found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	

}
