package com.ty.logestics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.logestics.util.ResponseStructure;



@ControllerAdvice
public class ApplicationExceptionalHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFoundException ex){
		ResponseStructure<String> structre= new ResponseStructure<String>();
		structre.setMessage(ex.getMessage());
		structre.setStatus(HttpStatus.NOT_FOUND.value());
		structre.setData("no company for given id");
		return new ResponseEntity<ResponseStructure<String>> (structre, HttpStatus.NOT_FOUND);
	
	}

}
