package com.austin.annotationsdemo.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class FileFortuneService implements FortuneService {
	
	@Value("${foo.fortunes}")
	private String[] fortunesFromFile;
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		return fortunesFromFile[random.nextInt(fortunesFromFile.length)];
	}

}
