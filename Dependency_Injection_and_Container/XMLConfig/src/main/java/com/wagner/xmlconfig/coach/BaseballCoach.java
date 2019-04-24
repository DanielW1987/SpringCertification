package com.wagner.xmlconfig.coach;

import com.wagner.xmlconfig.service.FortuneService;

public class BaseballCoach implements Coach {

  private final FortuneService fortuneService;

  public BaseballCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Spend 30 minutes on batting practices";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}