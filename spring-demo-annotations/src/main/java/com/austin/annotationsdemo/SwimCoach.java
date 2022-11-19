package com.austin.annotationsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.austin.annotationsdemo.services.FortuneService;

@Component
class SwimCoach implements Coach {
	
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Swim 100y then push yourself!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
