package com.austin.springdemo;

public class MyApp {
	
	public static void main(String[] args) {
		
		//create the obj
		Coach theCoach = new TrackCoach();
		
		//use the obj
		System.out.println(theCoach.getDailyWorkout());
	}
	
}
