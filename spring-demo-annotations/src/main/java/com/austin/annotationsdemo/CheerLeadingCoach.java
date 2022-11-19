package com.austin.annotationsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.austin.annotationsdemo.services.FortuneService;

@Component
public class CheerLeadingCoach implements Coach {

	// field injection of dependencies
	@Autowired
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Practice cheers and tumbles for one hour.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
