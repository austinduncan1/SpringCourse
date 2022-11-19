package com.austin.springdemo;

import com.austin.springdemo.services.FortuneService;

public class FootballCoach implements Coach {
	private FortuneService fortuneService;
	
	FootballCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Lift weights: 6 exercises, 4 sets each.";
	}

	@Override
	public String getDailyFortune() {
		return "Have a tackletastic day: " + fortuneService.getFortune();
	}

}
