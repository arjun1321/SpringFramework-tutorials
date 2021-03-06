package com.kumararjun.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// Read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get the bean from Spring container
		//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// Call a method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		// Call method getDailyFortune()
		System.out.println(theCoach.getDailyFortune());
		
		// Close the context  
		context.close();
	}

}
