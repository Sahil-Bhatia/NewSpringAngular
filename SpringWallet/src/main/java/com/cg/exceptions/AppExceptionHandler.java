package com.cg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//This class is NOT a controller, but an Assistant to ALL controller within Application
@ControllerAdvice
public class AppExceptionHandler {

	/**
	 * Capture all Exceptions of type ApplicationException, and return a new
	 * HttpResponse: Message from Exception and Http Status CODE 404
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({ InsufficientFundException.class })
	public ResponseEntity<String> handleError(InsufficientFundException exception) {
		System.out.println("Exception handled");
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ AccountException.class })
	public ResponseEntity<String> handleError( AccountException exception) {
		System.out.println("Exception handled");
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}