package com.arjunkumar.springdemo.service;

import java.util.List;

import com.arjunkumar.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomers(int theID);

	public void deleteCustomer(int theId);
}