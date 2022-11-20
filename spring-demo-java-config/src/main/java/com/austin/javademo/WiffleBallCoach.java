package com.austin.javademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.austin.javademo.services.FortuneService;

@Component
public class WiffleBallCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Practice your throws everyday!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
