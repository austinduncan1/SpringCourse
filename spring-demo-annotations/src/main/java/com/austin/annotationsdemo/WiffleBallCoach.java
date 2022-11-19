package com.austin.annotationsdemo;

import org.springframework.stereotype.Component;

// example of a component without a bean-id
@Component
public class WiffleBallCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice handling a light weight wiffle ball";
	}

}
