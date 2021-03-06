package com.arjunkumar.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.arjunkumar.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the customer
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomers(int theID) {
		// get the current Hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// retrieve customer from database using primary key
		Customer customer = session.get(Customer.class, theID);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// get the current Hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// delete the customer with primary id
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", theId);
		
	    query.executeUpdate();
	}
	
}
