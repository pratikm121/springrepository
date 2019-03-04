package nl.pratik.rest.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import nl.pratik.rest.spring.model.ErrorResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class MyCustomGlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(DataNotFoundException ex){
		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(ex.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		System.out.println("DataNotFoundException handleException called" + ex);
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		ErrorResponse error = new ErrorResponse();
		error.setErrorMessage(ex.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		System.out.println("General handleException called" + ex);
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
