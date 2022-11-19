package com.austin.springdemo.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.austin.springdemo.Coach;
import com.austin.springdemo.GolfCoach;


/**
 * Spring made app configurable
 * 
 * We can now easily change to different sport coach
 * */
class HelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach golfCoach = context.getBean("golfCoach", GolfCoach.class);
		
		// call method on bean
		System.out.println("myCoach: " + theCoach.getDailyWorkout());
		
		System.out.println("myCoach: " + theCoach.getDailyFortune());
		
		System.out.println("golfCoach: " + golfCoach.getDailyWorkout());
		
		System.out.println("golfCoach: " + golfCoach.getDailyFortune());	
		
		// close the context
		context.close();
	}

}