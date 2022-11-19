package com.austin.annotationsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.austin.annotationsdemo.services.FortuneService;

// example of a component without a bean-id
@Component
public class WiffleBallCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

	@Override
	public String getDailyWorkout() {
		return "Practice handling a light weight wiffle ball";
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getTeam()
	{
		return team;
	}
	
	/**
	 * @implNote for dependency injection, if using Autowired, do not need to use setter, could be ANY method name
	 * */
	@Autowired
	@Qualifier("databaseFortuneService") 
	public void setFortuneService(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}

}
