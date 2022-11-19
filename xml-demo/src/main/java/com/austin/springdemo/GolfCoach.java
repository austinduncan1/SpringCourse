package com.austin.springdemo;

import com.austin.springdemo.services.FortuneService;

public class GolfCoach implements Coach {
	
	private FortuneService fortuneService;
	
	GolfCoach(FortuneService fortuneService)
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
	
	//init method
	private void initGolfCoach()
	{
		System.out.println("Initializing GolfCoach!");
	}
	
	//destroy method
	private void destroyGolfCoach()
	{
		System.out.println("Destroying GolfCoach!");
	}

}
