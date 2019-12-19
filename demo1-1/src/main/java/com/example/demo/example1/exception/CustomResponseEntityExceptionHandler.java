package com.example.demo.example1.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.example1.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
public final ResponseEntity<Object>	handleAllException(Exception e, WebRequest request){
	
	
	ExceptionResponce exception	= new ExceptionResponce(request.getDescription(true),e.getMessage(),new Date());
	ResponseEntity<Object> entity= new ResponseEntity<Object>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	return entity;

}
	@ExceptionHandler(UserNotFoundException.class)
public final ResponseEntity<Object>	handleUserNotFoundException(UserNotFoundException e, WebRequest request){
	
	
	ExceptionResponce exception	= new ExceptionResponce(request.getDescription(true),e.getMessage(),new Date());
	ResponseEntity<Object> entity= new ResponseEntity<Object>(exception, HttpStatus.NOT_FOUND);
	return entity;

}


}
