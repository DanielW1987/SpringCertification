package com.wagner.javaconfig.config;

import com.wagner.javaconfig.coach.BaseballCoach;
import com.wagner.javaconfig.coach.Coach;
import com.wagner.javaconfig.coach.SwimCoach;
import com.wagner.javaconfig.coach.TennisCoach;
import com.wagner.javaconfig.service.FortuneService;
import com.wagner.javaconfig.service.HappyFortuneService;
import com.wagner.javaconfig.service.RandomFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// @ComponentScan("com.wagner") // not necessary when there are no @Component classes within the application
@Configuration
@PropertySource("classpath:sport.properties")
public class ApplicationConfig {
	
	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	@Bean
	public FortuneService randomFortuneService() {
		return new RandomFortuneService();
	}
	
	@Bean
	public Coach baseballCoach() {
		BaseballCoach baseballCoach = new BaseballCoach();
		baseballCoach.setFortuneService(randomFortuneService());
		return baseballCoach;
	}
	
	@Bean
	public Coach tennisCoach() {
		// note that happyFortuneService is not used as singleton here
		return new TennisCoach(happyFortuneService());
	}
	
	@Bean
	public Coach swimCoach() {
		// note that happyFortuneService is not used as singleton here
		return new SwimCoach(happyFortuneService());
	}
}