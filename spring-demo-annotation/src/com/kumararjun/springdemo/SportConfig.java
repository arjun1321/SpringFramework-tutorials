package com.kumararjun.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.kumararjun.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// Define bean for sadFortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	// Define bean for SwimCoach and add dependencies
	@Bean
	public Coach swimCoach(FortuneService fortuneService) {
		SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
		
		return mySwimCoach;
	}
	
}
