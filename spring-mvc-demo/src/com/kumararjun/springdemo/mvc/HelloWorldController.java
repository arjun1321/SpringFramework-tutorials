package com.kumararjun.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	// Need a controller method to show the initial html form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// Need a controller  method to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// Need a controller method to read from data and add it to the model
	
	@RequestMapping("processFormVersionTwo")
	public String letsShoutDude( HttpServletRequest request, Model model) {
		
		// Read the  request parameter from the  HTML form
		String theName = request.getParameter("studentName");
		
		// Convert the data to capital letters
		theName = theName.toUpperCase();
		
		// Create the message 
		String result = "Yo! " + theName;
		
		// Add the message to Model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
