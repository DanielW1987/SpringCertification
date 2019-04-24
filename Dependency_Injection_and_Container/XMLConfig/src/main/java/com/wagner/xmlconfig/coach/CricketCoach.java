package com.wagner.xmlconfig.coach;

import com.wagner.xmlconfig.service.FortuneService;

public class CricketCoach implements Coach {

  private FortuneService fortuneService;
  private String emailAddress;
  private String team;

  public void setFortuneService(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  @Override
  public String getDailyWorkout() {
    return "Practice fast bowling for 15 minutes.";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  @Override
  public String toString() {
    return emailAddress + " | " + team;
  }

}
