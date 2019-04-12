package com.arjunkumar.springdemo.dao;

import java.util.List;

import com.arjunkumar.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomers(int theID);

	public void deleteCustomer(int theId);
}
