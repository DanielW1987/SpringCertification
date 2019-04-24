package com.wagner.annotationconfig.coach;

import com.wagner.annotationconfig.service.FortuneService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Using constructor injection and method injection
 * @author daniel
 */
@Component
@Scope("singleton") // not necessary to do this explicitly
public class TennisCoach implements Coach, InitializingBean, DisposableBean {

	private final FortuneService fortuneService;
	
	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
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
	
	@Autowired
	@Qualifier("randomFortuneService")
	public void injectWhereverYouWant(FortuneService fortuneService) {
		System.out.println("I've been injected -> " + fortuneService.getFortune());
	}

	// afterPropertiesSet of InitializingBean as an alternative to @PostConstruct
	@Override
	public void afterPropertiesSet() {
		// runs after constructor call and injection of dependencies
		System.out.println("Do some initialization stuff!");
	}
	
	// destroy() of DisposableBean as an alternative to @PreDestroy
	@Override
	public void destroy() {
		// runs before bean is destroyed
		System.out.println("Do some cleanup stuff!");
	}
}