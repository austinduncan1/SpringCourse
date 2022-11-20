package com.austin.javademo.runners;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.austin.javademo.Coach;
import com.austin.javademo.SwimCoach;
import com.austin.javademo.WiffleBallCoach;
import com.austin.javademo.config.CustomSportConfig;
import com.austin.javademo.config.SportConfig;

public class JavaConfigDemoRunner {

	public static void main(String[] args) {
		
		//Read Spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// example of retrieving bean with no specific bean-id set in class annotation (simply camel case of class name)
		// setter dependency injection used for this example
		
		// uses component scanning and annotations, the uses Java config to setup component scanning
		WiffleBallCoach theWiffleBallCoach = context.getBean("wiffleBallCoach", WiffleBallCoach.class);
		
		// manually setup as bean in java config file, no annotations used
		SwimCoach theSwimCoach = context.getBean("swimCoach", SwimCoach.class);
		
				
		// do something with beans
		System.out.println("Swim Coach email: " + theSwimCoach.getEmail());
		System.out.println("SwimCoach team: " + theSwimCoach.getTeam());
				
		System.out.println("Wiffle Ball workout: " + theWiffleBallCoach.getDailyWorkout());
		
		System.out.println("Wiffle Ball fortune: " + theWiffleBallCoach.getDailyFortune());
		
		System.out.println("Swim workout: " + theSwimCoach.getDailyWorkout());
		
		System.out.println("Swim fortune: " + theSwimCoach.getDailyFortune());
		
		System.out.println("Closing container...");
		
		// close container
		context.close();
		
		System.out.println("Moving to tests of custom config and HandBallCoach...");
		AnnotationConfigApplicationContext customContext = new AnnotationConfigApplicationContext(CustomSportConfig.class);
		
		Coach handBallCoach = customContext.getBean("handballCoach", Coach.class);
		
		System.out.println("Handball workout: " + handBallCoach.getDailyWorkout());
		System.out.println("Handball fortune: " + handBallCoach.getDailyFortune());
		
		System.out.println("Closing container...");
		customContext.close();
	}

}
