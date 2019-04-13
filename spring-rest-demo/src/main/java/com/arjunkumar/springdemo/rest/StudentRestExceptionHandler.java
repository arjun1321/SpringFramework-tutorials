package com.arjunkumar.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add exception handling here
	
	// Add an Exception handler using @ExceptionHandler
	
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
			// create a student error response
			
			StudentErrorResponse error = new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
		}
		
		// Add another exception handler to catch any exception
		
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
			// create a student error response
			
					StudentErrorResponse error = new StudentErrorResponse();
					error.setStatus(HttpStatus.BAD_REQUEST.value());
					error.setMessage(exc.getMessage());
					error.setTimeStamp(System.currentTimeMillis());
					
					return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
		}
}
