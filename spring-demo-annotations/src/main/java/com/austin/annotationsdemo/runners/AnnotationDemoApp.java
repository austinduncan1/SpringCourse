package com.austin.annotationsdemo.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.austin.annotationsdemo.Coach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// load Spring config?
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean using bean-id
		Coach theTennisCoach = context.getBean("theTennisCoach", Coach.class);
		
		// example of retrieving bean with no specific bean-id set in class annotation (simply camel case of class name)
		Coach theWiffleBallCoach = context.getBean("wiffleBallCoach", Coach.class);
		
		// do something with bean
		System.out.println("Tennis workout: " + theTennisCoach.getDailyWorkout());
		
		System.out.println("Wiffle Ball workout: " + theWiffleBallCoach.getDailyWorkout());
		
		// close container
		context.close();
	}

}
