package com.kumararjun.springdemo;

public class GolfCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public GolfCoach() {
		
	}
	
	public GolfCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		return "Practice your putting skills for 2 hours today";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
