package com.wagner.xmlconfig;

import com.wagner.xmlconfig.coach.Coach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLConfigApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach cricketCoach = context.getBean("cricketCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		System.out.println(cricketCoach);

    ((ConfigurableApplicationContext) context).close();

  }

}
