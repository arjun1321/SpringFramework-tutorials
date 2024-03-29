package com.kumararjun.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	public FortuneService fortuneService;
	
	// Default constructor
	public TennisCoach() {
		System.out.println("TennisCoach: inside default constructor");
	}
	
	// Define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: Inside doMyStartupStuff method");
	}
	
	// Define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: Inside doMyCleanupStuff method");
	}
	
	
	/*
	// Define a setter method
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("TennisCoach : inside setFortuneService method");
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	@Autowired
	public TennisCoach (FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
