package com.kumararjun.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] data = {
			"Beware of the wolf in sheep's clothing",
			"Dilligence is the mother of goodluck",
			"The journey is the reward"
	};
	
	
	private Random random = new Random();

	@Override
	public String getFortune() {
		
		int index = random.nextInt(data.length);
		String theFortune = data[index];
		
		return theFortune;
	}

}
