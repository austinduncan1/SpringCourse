package com.austin.annotationsdemo.services;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
class RandomFortuneService implements FortuneService {

	private String[] fortunes = new String[] {"You will have a successful day.", "You will meet someone who needs you as much as you need them.", "Beware of the wolf in sheep's clothing"};
	private Random randomGen = new Random();
	
	@Override
	public String getFortune() {
		return fortunes[randomGen.nextInt(fortunes.length)];
	}

}
