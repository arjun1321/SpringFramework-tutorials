package com.arjunkumar.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arjunkumar.springboot.cruddemo.entity.Employee;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// Define field for entity manager
	
	private EntityManager entityManager;
	
	// define constructor for entity manager
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		
		// get the current Hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create the query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		// execute the query
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		
		return employees;
	}


	@Override
	public Employee findById(int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employees
		Employee employee = currentSession.get(Employee.class, id);
	
		return employee;
	}


	@Override
	public void saveEmployee(Employee employee) {
		// get the current hibernate session
		Session currSession = entityManager.unwrap(Session.class);
		
		// save employee
		currSession.saveOrUpdate(employee); // if id is 0 then insert and if id is > 0 then update
		
	}


	@Override
	public void deleteById(int id) {
		// get the current hibernate session
		Session currSession = entityManager.unwrap(Session.class);
		
		// delete the employee with employee id
		Query theQuery = currSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();
		
	}

}
