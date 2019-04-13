package com.arjunkumar.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arjunkumar.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	// define @PostConstruct to load the student data only once
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<Student>();
		
		theStudents.add(new Student("Arjun", "Kumar"));
		theStudents.add(new Student("Roshan", "Sahu"));
		theStudents.add(new Student("Rohit", "Gupta"));
		theStudents.add(new Student("Preeti", "Gupta"));
	}

	// define endpoints for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudents;
	}
	
	// define endpoint for "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// check the studentId againset the list size
		if ((studentId >= theStudents.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
//	// Add an Exception handler using @ExceptionHandler
//	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//		// create a student error response
//		
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
//	}
//	
//	// Add another exception handler to catch any exception
//	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//		// create a student error response
//		
//				StudentErrorResponse error = new StudentErrorResponse();
//				error.setStatus(HttpStatus.BAD_REQUEST.value());
//				error.setMessage(exc.getMessage());
//				error.setTimeStamp(System.currentTimeMillis());
//				
//				return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
//	}
}
