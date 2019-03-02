package com.arjunkumar.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arjunkumar.springdemo.dao.CustomerDAO;
import com.arjunkumar.springdemo.entity.Customer;
import com.arjunkumar.springdemo.service.CustomerService;



@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {	
		
		// get customers from service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add customers to the model
		model.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}

}
