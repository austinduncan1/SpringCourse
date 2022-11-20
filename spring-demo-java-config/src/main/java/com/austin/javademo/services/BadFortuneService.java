package com.austin.javademo.services;

public class BadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today will be a bad day!";
	}

}
