package com.wagner.annotationconfig;

import com.wagner.annotationconfig.coach.Coach;
import com.wagner.annotationconfig.config.ApplicationConfig;
import com.wagner.annotationconfig.logging.LoggerConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDemoApp {

  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class, LoggerConfig.class);

    Coach tennisCoach   = context.getBean("tennisCoach"  , Coach.class);
    Coach footballCoach = context.getBean("footballCoach", Coach.class);
    Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
    Coach swimCoach     = context.getBean("swimCoach"    , Coach.class);

    System.out.println("Tennis Coach");
    System.out.println(tennisCoach.getDailyWorkout());
    System.out.println(tennisCoach.getDailyFortune());

    System.out.println();

    System.out.println("Football Coach");
    System.out.println(footballCoach.getDailyWorkout());
    System.out.println(footballCoach.getDailyFortune());

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