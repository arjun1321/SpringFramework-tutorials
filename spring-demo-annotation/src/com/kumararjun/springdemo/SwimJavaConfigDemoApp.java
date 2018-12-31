package com.kumararjun.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// Read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// Get the bean from Spring container
		//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// Call a method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		// Call method getDailyFortune()
		System.out.println(theCoach.getDailyFortune());
		
		
		// Call our new SwimCoach methods
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		
		// Close the context  
		context.close();
	}

}
