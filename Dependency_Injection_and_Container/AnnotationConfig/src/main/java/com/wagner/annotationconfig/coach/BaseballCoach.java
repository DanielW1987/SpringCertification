package com.wagner.annotationconfig.coach;

import com.wagner.annotationconfig.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * using setter injection
 * @author daniel
 */
@Component
@Scope("singleton") // not necessary to do this explicitly
public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Autowired
	@Qualifier("fileBasedFortuneService")
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