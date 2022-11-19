package com.austin.springdemo.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.austin.springdemo.Coach;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if coachs are the same
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nPointing to the same object: " + result + ".\nReferences...\ntheCoach: " + theCoach + ",\nalphaCoach: " + alphaCoach);
		context.close();
	}

}
