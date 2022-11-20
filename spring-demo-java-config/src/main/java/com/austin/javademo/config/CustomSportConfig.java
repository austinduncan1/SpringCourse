package com.austin.javademo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.austin.javademo.Coach;
import com.austin.javademo.HandBallCoach;
import com.austin.javademo.services.BadFortuneService;
import com.austin.javademo.services.FortuneService;

@Configuration
public class CustomSportConfig {
	
	@Bean
	public FortuneService badFortuneService()
	{
		return new BadFortuneService();
	}
	
	@Bean
	public Coach handballCoach()
	{
		return new HandBallCoach(badFortuneService());
	}

}
