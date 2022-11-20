package com.austin.javademo;

import com.austin.javademo.services.FortuneService;

public class HandBallCoach implements Coach {

	private FortuneService fortuneService;
	
	public HandBallCoach(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice handball twice a day, once singles and once doubles";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
