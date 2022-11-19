package com.austin.springdemo.runners;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.austin.springdemo.Coach;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		// load Spring config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		// retrieve bean
		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		
		// close the context
		context.close();
	}

}
