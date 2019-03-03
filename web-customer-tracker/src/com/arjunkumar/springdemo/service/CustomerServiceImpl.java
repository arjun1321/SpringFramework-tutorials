package com.arjunkumar.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arjunkumar.springdemo.dao.CustomerDAO;
import com.arjunkumar.springdemo.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	// Need to inject Customer DAO
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomers(int theID) {
		
		return customerDAO.getCustomers(theID);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}

}
