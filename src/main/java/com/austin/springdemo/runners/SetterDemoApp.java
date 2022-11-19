package com.austin.springdemo.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.austin.springdemo.CricketCoach;

class SetterDemoApp {

	public static void main(String[] args) {
		
		// load props file as spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		CricketCoach myCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on bean
		System.out.println(myCoach.getDailyFortune());
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getEmailAddress());
		System.out.println(myCoach.getTeam());
		
		// close the context
		context.close();
	}

}
