package com.wagner.annotationconfig.coach;

import com.wagner.annotationconfig.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * using field injection
 * @author daniel
 */
@Component
@Scope("singleton") // not necessary to do this explicitly
public class FootballCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Practice penalty";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}	
}