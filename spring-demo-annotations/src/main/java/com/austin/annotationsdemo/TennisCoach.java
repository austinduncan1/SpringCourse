package com.austin.annotationsdemo;

import org.springframework.stereotype.Component;

import com.austin.annotationsdemo.Coach;

@Component("theTennisCoach")
public class TennisCoach implements Coach {
	
	@Override
	public String getDailyWorkout()
	{
		return "Practice your backhand volley";
	}
}
