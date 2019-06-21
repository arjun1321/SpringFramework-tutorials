package com.arjunkumar.springboot.cruddemo.service;

import java.util.List;

import com.arjunkumar.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteById(int id);
}
