package com.examplerest.webservice.exception;

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

@ControllerAdvice	
@RestController
public class CustomizeExceptionHandling extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception exception, WebRequest webRequest){
		
	ExceptionResponse exceptionResponse =new ExceptionResponse(new Date(),exception.getMessage(),webRequest.getDescription(false));
 
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFopundExceptionException(UserNotFoundException exception, WebRequest webRequest){
		
	ExceptionResponse exceptionResponse =new ExceptionResponse(new Date(),exception.getMessage(),webRequest.getDescription(false));
 
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.springframework.web.bind.MethodArgumentNotValidException, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	// TODO Auto-generated method stub
		ExceptionResponse exceptionResponse =new ExceptionResponse(new Date(),"Validation Failed",ex.getBindingResult().toString());
		 
		return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	
}
