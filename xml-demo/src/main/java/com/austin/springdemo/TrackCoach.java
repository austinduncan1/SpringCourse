package com.austin.springdemo;

import com.austin.springdemo.services.FortuneService;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	public TrackCoach () {}
	
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: " + fortuneService.getFortune();
	}
	
	// init method
	private void doMyStartupStuff()
	{
		System.out.println("TrackCoach: inside init method!");
	}
	
	//destroy method
	private void doMyCleanupStuff()
	{
		System.out.println("TrackCoach: inside destroy method!");
	}
}
