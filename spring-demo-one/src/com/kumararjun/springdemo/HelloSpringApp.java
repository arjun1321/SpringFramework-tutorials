package com.kumararjun.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// Load the configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieving Bean from container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call the method on bean
		System.out.println(theCoach.getDailyWorkOut());
		
		// Lets call our new method for Fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Close the bean
		context.close();

	}

}
