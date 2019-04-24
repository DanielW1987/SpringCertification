package com.wagner.javaconfig.coach;

import com.wagner.javaconfig.service.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	@Value("${email}")
	private String email;
	
	@Value("${team}")
	private String team;
	
	private final FortuneService fortuneService;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim around with your team (" + team + ")!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}