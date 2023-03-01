package com.ty.logestics.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.logestics.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionalHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFoundException ex) {
		ResponseStructure<String> structre = new ResponseStructure<String>();
		structre.setMessage(ex.getMessage());
		structre.setStatus(HttpStatus.NOT_FOUND.value());
		structre.setData("no company for given id");
		return new ResponseEntity<ResponseStructure<String>>(structre, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementExceptionHandler(NoSuchElementException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("no company for given id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> productIdNotFoundExceptionHandler(ProductIdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("no product found for given id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(GoodsIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> goodsIdNotFoundExceptionHandler(GoodsIdNotFoundException ex) {

		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setMessage(ex.getMsg());
		rs.setStatus(HttpStatus.NOT_FOUND.value());
		rs.setData("no goods found for  given id");

		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.NOT_FOUND);

	}

}
