package com.zensar.spring.JUnitDemo;

public class GreetingServiceImpl implements GreetingService{

	public String greet(String name) {
		return "Hello "+name;
		
	}

}
