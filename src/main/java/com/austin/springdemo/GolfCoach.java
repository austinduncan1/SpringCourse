package com.austin.springdemo;

public class GolfCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public GolfCoach(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice swings for 1 hour per day";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
