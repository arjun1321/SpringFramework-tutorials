package com.arjunkumar.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arjunkumar.aopdemo.dao.AccountDAO;
import com.arjunkumar.aopdemo.dao.MembershipDAO;
import com.arjunkumar.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger mylogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		mylogger.info("\nMain Program: Around demo app");
		mylogger.info("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		mylogger.info("\nMy fortune is: " + data);
		mylogger.info("Finished");
		
		// close the context
		context.close();
	}

}
