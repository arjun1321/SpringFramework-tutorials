package com.arjunkumar.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.arjunkumar.springboot.cruddemo.entity.Employee;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// no need to write any code here
}
