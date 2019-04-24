package com.wagner.xmlconfig.coach;

import com.wagner.xmlconfig.service.FortuneService;

public class TrackCoach implements Coach {

	private final FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	private void init() {
		System.out.println("do init stuff");
	}
	
	private void destroy() {
		System.out.println("do cleanup stuff");
	}
	
}