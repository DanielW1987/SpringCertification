package com.wagner.javaconfig.coach;

import com.wagner.javaconfig.service.FortuneService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TennisCoach implements Coach {

	private final FortuneService fortuneService;
	
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	private void init() {
		// runs after constructor call and injection of dependencies
		System.out.println("Do some initialization stuff!");
	}
	
	@PreDestroy
	private void destroy() {
		// runs before bean is destroyed
		System.out.println("Do some cleanup stuff!");
	}
}