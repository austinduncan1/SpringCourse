package com.austin.annotationsdemo.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.austin.annotationsdemo.Coach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// load Spring config?
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean using bean-id
		// constructor dependency injection used for this example
		Coach theTennisCoach = context.getBean("theTennisCoach", Coach.class);
		
		// example of retrieving bean with no specific bean-id set in class annotation (simply camel case of class name)
		// setter dependency injection used for this example
		Coach theWiffleBallCoach = context.getBean("wiffleBallCoach", Coach.class);
				
		// do something with beans
		System.out.println("Tennis workout: " + theTennisCoach.getDailyWorkout());
		
		System.out.println("Wiffle Ball workout: " + theWiffleBallCoach.getDailyWorkout());
		
		System.out.println("Tennis fortune: " + theTennisCoach.getDailyFortune());
		
		System.out.println("Wiffle Ball fortune: " + theWiffleBallCoach.getDailyFortune());
		
		// close container
		context.close();
	}

}
