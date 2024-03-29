package com.kumararjun.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// Load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from the spring container
		Coach theCoach = context.getBean("tennisCoach",  Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		
		// Check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		
		// Printing the result
		System.out.println("Pointing to the same objects: " + result);
		
		System.out.println("Memory location of theCoach " + theCoach);
		System.out.println("Memory locationn of alphaCoach " + alphaCoach);
		
		// Close the context
		context.close();

	}

}
