package com.austin.annotationsdemo.services;

import org.springframework.stereotype.Component;

@Component
class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "REST fortune";
	}

}
