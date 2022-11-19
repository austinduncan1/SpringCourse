package com.austin.annotationsdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.austin.annotationsdemo.Coach;
import com.austin.annotationsdemo.services.FortuneService;

@Component("theTennisCoach")
class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
		System.out.println("TennisCoach Constructor called");
	}
	
	@PostConstruct
	public void initMethod()
	{
		System.out.println("Doing some init stuff in TennisCoach");
	}
	
	@PreDestroy
	public void destroyMethod()
	{
		System.out.println("Doing some destroy stuff in TennisCoach");
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
