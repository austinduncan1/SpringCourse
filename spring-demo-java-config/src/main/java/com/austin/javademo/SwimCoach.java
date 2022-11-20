package com.austin.javademo;

import org.springframework.beans.factory.annotation.Value;

import com.austin.javademo.Coach;
import com.austin.javademo.services.FortuneService;

/**
 * When manually doing bean definitions in Java config, no need for annotations as you will not use component scanning
 * */
public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}
	
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}
	
	public String getDailyWorkout()
	{
		return "Swim 100y twice today";
	}
	
	public String getTeam()
	{
		return team;
	}
	
	public String getEmail()
	{
		return email;
	}
	
}
