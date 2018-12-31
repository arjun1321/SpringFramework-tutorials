package com.kumararjun.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {
		"my name is Arjun Kumar",
		"who are you",
		"i love you so much"
	};
	
	
	// Create a random no generator
	private  Random random = new Random();
	
	@Override
	public String getFortune() {
		// Pick a random string from the array
		int index = random.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
