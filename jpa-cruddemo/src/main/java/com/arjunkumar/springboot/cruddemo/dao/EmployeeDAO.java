package com.arjunkumar.springboot.cruddemo.dao;

import java.util.List;

import com.arjunkumar.springboot.cruddemo.entity.Employee;


public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void saveEmployee(Employee employee);
	
	public void deleteById(int id);
}
