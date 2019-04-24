package com.wagner.javaconfig.coach;

import com.wagner.javaconfig.service.FortuneService;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice bet";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}