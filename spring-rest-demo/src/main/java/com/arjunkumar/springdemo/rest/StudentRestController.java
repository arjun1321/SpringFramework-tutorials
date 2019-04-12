package com.arjunkumar.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arjunkumar.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define endpoints for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		List<Student> theStudents = new ArrayList<Student>();
		
		theStudents.add(new Student("Arjun", "Kumar"));
		theStudents.add(new Student("Roshan", "Sahu"));
		theStudents.add(new Student("Rohit", "Gupta"));
		theStudents.add(new Student("Preeti", "Gupta"));
		
		return theStudents;
	}
}
