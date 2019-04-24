package com.wagner.annotationconfig.coach;

import com.wagner.annotationconfig.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Inject value from properties file
 * @author daniel
 */
@Component
@Scope("singleton") // not necessary to do this explicitly
public class SwimCoach implements Coach {

	@Value("${email}")
	private String email;
	
	@Value("${team}")
	private String team;
	
	private final FortuneService fortuneService;
	
	@Autowired
	public SwimCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
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