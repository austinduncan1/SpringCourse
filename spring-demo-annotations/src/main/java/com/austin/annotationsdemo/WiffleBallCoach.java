package com.austin.annotationsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.austin.annotationsdemo.services.FortuneService;

// example of a component without a bean-id
@Component
public class WiffleBallCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

	@Override
	public String getDailyWorkout() {
		return "Practice handling a light weight wiffle ball";
	}
	
	/**
	 * @implNote for dependency injection, if using Autowired, do not need to use setter, could be ANY method name
	 * */
	@Autowired
	public void setFortuneService(@Qualifier("databaseFortuneService") FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}

}
