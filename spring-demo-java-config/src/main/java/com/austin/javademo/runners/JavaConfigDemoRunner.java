package com.austin.javademo.runners;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.austin.javademo.WiffleBallCoach;
import com.austin.javademo.config.SportConfig;

public class JavaConfigDemoRunner {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// example of retrieving bean with no specific bean-id set in class annotation (simply camel case of class name)
		// setter dependency injection used for this example
		WiffleBallCoach theWiffleBallCoach = context.getBean("wiffleBallCoach", WiffleBallCoach.class);
		
		
				
		// do something with beans
		//System.out.println("Wiffle Ball email: " + theWiffleBallCoach.getEmail());
		//System.out.println("Wiffle Ball team: " + theWiffleBallCoach.getTeam());
				
		System.out.println("Wiffle Ball workout: " + theWiffleBallCoach.getDailyWorkout());
		
		System.out.println("Wiffle Ball fortune: " + theWiffleBallCoach.getDailyFortune());
		
		System.out.println("Closing container...");
		
		// close container
		context.close();
	}

}
