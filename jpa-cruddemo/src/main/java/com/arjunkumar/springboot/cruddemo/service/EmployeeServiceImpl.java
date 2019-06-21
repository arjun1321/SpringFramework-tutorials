package com.arjunkumar.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arjunkumar.springboot.cruddemo.dao.EmployeeDAO;
import com.arjunkumar.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	// Inject EmployeeDAO
	private EmployeeDAO employeeDAO;
	
	// constructor injection
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		employeeDAO.deleteById(id);
	}

}
