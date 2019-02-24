package com.arjunkumar.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arjunkumar.springdemo.dao.CustomerDAO;
import com.arjunkumar.springdemo.entity.Customer;



@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomer(Model model) {	
		
		// get customers from dao
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		// add customers to the model
		model.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}

}
