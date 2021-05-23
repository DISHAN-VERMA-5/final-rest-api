package com.dishan.myrestapi.user;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//@ControllerAdvice annotation tells us that the below code will be applied to all the controllers that are present in your project
@ControllerAdvice
@RestController
public class CutomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	//handle all the normal exceptions
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		ResponseException responseException=new ResponseException(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object> (responseException,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//handle all the usernotfoundexceptions
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleAllUserNotFoundException(Exception ex, WebRequest request){
		ResponseException responseException=new ResponseException(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object> (responseException,HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ResponseException responseException=new ResponseException(new Date(),ex.getLocalizedMessage(),request.getDescription(false));
		return new ResponseEntity<Object> (responseException,HttpStatus.NOT_FOUND);
		
	}
	
	
}
