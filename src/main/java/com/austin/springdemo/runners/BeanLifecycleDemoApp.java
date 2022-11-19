package com.austin.springdemo.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.austin.springdemo.Coach;
import com.austin.springdemo.GolfCoach;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		// load Spring config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		// retrieve bean
		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		
		// retrieve my golf coach, which should be a prototype (retrieve 2 for testing)
		Coach golfCoach = context.getBean("myGolfCoach", Coach.class);
		Coach secondGolfCoach = context.getBean("myGolfCoach", GolfCoach.class);
		
		boolean golfCoachesAreNotTheSame = (golfCoach != secondGolfCoach);
		
		System.out.println("Prototype scope, so not the same: " + golfCoachesAreNotTheSame);
		
		// close the context
		context.close();
	}

}
