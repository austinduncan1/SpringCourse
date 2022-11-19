package com.austin.springdemo.runners;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.austin.springdemo.Coach;
import com.austin.springdemo.CricketCoach;
import com.austin.springdemo.GolfCoach;
import com.austin.springdemo.TrackCoach;

public class SpringDemoApp {

	public static void main(String[] args) {
		// load the spring config file
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		performCreationWithConstructor();
		performCreationWithSpringXmlConfig(applicationContext);
		performCreationWithXmlDepInj(applicationContext);
		
		// load the spring config file
		ClassPathXmlApplicationContext scopeContext = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		workWithDifferentScopes(scopeContext);
		
		// load Spring config
		ClassPathXmlApplicationContext lifecycleContext = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");
		
		outputLifeCycleDemo(lifecycleContext);
		
		applicationContext.close();
		scopeContext.close();
		lifecycleContext.close();
	}
	
	public static void performCreationWithConstructor()
	{
		StackWalker walker = StackWalker.getInstance();
	    Optional<String> methodName = walker.walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName));
		
		//create the obj
		Coach theCoach = new TrackCoach();
		
		if (methodName.isPresent())
		{
			System.out.print("Working in method " + methodName.get() + ": ");
		}
		//use the obj
		System.out.println(theCoach.getDailyWorkout() + "\n");
		
		
	}
	
	public static void performCreationWithSpringXmlConfig(ClassPathXmlApplicationContext context)
	{
		StackWalker walker = StackWalker.getInstance();
		Optional<String> methodName = walker.walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName));
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach golfCoach = context.getBean("golfCoach", GolfCoach.class);
		
		// call method on bean
		if (methodName.isPresent())
		{
			System.out.println("Working in method " + methodName.get() + ": ");
		}
		System.out.println("myCoach: " + theCoach.getDailyWorkout());
		
		System.out.println("myCoach: " + theCoach.getDailyFortune());
		
		System.out.println("golfCoach: " + golfCoach.getDailyWorkout());
		
		System.out.println("golfCoach: " + golfCoach.getDailyFortune() + "\n");	
		
	}
	
	public static void performCreationWithXmlDepInj(ClassPathXmlApplicationContext context)
	{
		StackWalker walker = StackWalker.getInstance();
		Optional<String> methodName = walker.walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName));
		
		// retrieve bean from spring container
		CricketCoach myCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		if (methodName.isPresent())
		{
			System.out.println("Working in method " + methodName.get() + ": ");
		}
		
		// call methods on bean
		System.out.println(myCoach.getDailyFortune() + "\n");
		System.out.println(myCoach.getDailyWorkout() + "\n");
		System.out.println(myCoach.getEmailAddress() + "\n");
		System.out.println(myCoach.getTeam() + "\n");

	}
	
	public static void workWithDifferentScopes(ClassPathXmlApplicationContext context) {
		
		StackWalker walker = StackWalker.getInstance();
		Optional<String> methodName = walker.walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName));
		
		
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if coachs are the same
		boolean result = (theCoach == alphaCoach);
		
		if (methodName.isPresent())
		{
			System.out.println("Working in method " + methodName.get() + ": ");
		}
		
		System.out.println("\nPointing to the same object: " + result + ".\nReferences...\ntheCoach: " + theCoach + ",\nalphaCoach: " + alphaCoach + "\n");
	}
	
	public static void outputLifeCycleDemo(ClassPathXmlApplicationContext context)
	{
		StackWalker walker = StackWalker.getInstance();
		Optional<String> methodName = walker.walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName));
		
		// retrieve bean
		Coach myCoach = context.getBean("myCoach", Coach.class);
		
		if (methodName.isPresent())
		{
			System.out.println("Working in method " + methodName.get() + ": ");
		}
		
		System.out.println(myCoach.getDailyWorkout());
		
		// retrieve my golf coach, which should be a prototype (retrieve 2 for testing)
		Coach golfCoach = context.getBean("myGolfCoach", Coach.class);
		Coach secondGolfCoach = context.getBean("myGolfCoach", GolfCoach.class);
		
		boolean golfCoachesAreNotTheSame = (golfCoach != secondGolfCoach);
		
		System.out.println("Prototype scope, so not the same: " + golfCoachesAreNotTheSame + "\n");
		
	}

}
