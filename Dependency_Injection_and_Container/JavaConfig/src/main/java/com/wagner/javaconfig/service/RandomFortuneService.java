package com.wagner.javaconfig.service;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private final String[] data = {"Have a nice day!","Today is your lucky day!","Today is your day!"};
	private final Random random = new Random();
	
	@Override
	public String getFortune() {	
		return data[random.nextInt(data.length)];
	}	

}