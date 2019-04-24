package com.wagner.javaconfig;

import com.wagner.javaconfig.coach.Coach;
import com.wagner.javaconfig.config.ApplicationConfig;
import com.wagner.javaconfig.logging.LoggerConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigApp {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(LoggerConfig.class, ApplicationConfig.class);
		
		Coach tennisCoach   = context.getBean("tennisCoach"  , Coach.class);
		Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
		Coach swimCoach     = context.getBean("swimCoach"    , Coach.class);
		
		System.out.println("Tennis Coach");
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());
		
		System.out.println();
		
		System.out.println("Baseball Coach");
		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getDailyFortune());
		
		System.out.println();
		
		System.out.println("Swim Coach");
		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());

		((ConfigurableApplicationContext) context).close();
	}
}