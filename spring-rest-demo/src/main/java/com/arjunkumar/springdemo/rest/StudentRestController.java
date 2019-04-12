package com.arjunkumar.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
		return theStudents.get(studentId);
	}
}
