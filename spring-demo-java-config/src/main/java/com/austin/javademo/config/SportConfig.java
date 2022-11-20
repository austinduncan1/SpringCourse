package com.austin.javademo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.austin.javademo.Coach;
import com.austin.javademo.SwimCoach;
import com.austin.javademo.services.FortuneService;
import com.austin.javademo.services.HappyFortuneService;
import com.austin.javademo.services.SadFortuneService;

@Configuration
// use component scan if not defining beans in config as below
@ComponentScan("com.austin.javademo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// the below method of bean definitions is the same as defining in XML (manual injection of dependencies)
	
	// tell container that sadFortuneService will be a bean
	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
	}
	
	// define method for bean retrieval to have it setup in container
	@Bean
	public Coach swimCoach()
	{
		// inject dependency
		SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
		
		return mySwimCoach;
	}
		
}
