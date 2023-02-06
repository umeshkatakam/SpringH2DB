package com.example.demo.exception;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex,WebRequest req){
		
		ErrorMessage error=new ErrorMessage(
				
				HttpStatus.NOT_FOUND.value(), new Date(),ex.getMessage() , req.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(error,HttpStatus.NOT_FOUND);
	}
}
