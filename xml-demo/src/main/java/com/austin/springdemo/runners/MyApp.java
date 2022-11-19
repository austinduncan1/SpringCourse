package com.austin.springdemo.runners;

import com.austin.springdemo.Coach;
import com.austin.springdemo.TrackCoach;

class MyApp {
	
	public static void main(String[] args) {
		
		//create the obj
		Coach theCoach = new TrackCoach();
		
		//use the obj
		System.out.println(theCoach.getDailyWorkout());
	}
	
}
