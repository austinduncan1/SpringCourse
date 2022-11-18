package com.austin.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	String[] fortunes = new String[] {"Fortune1", "Fortune2", "Fortune3"};
	
	@Override
	public String getFortune() {
		return fortunes[new Random(System.currentTimeMillis()).nextInt(3)];
	}

}
