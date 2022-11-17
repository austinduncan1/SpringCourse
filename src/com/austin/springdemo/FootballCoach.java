package com.austin.springdemo;

public class FootballCoach implements Coach {
	private FortuneService fortuneService;
	
	public FootballCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Lift weights: 6 exercises, 4 sets each.";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Have a tackletastic day: " + fortuneService.getFortune();
	}

}
