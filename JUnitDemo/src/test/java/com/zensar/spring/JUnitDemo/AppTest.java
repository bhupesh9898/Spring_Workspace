package com.zensar.spring.JUnitDemo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

public class AppTest  {
	
	@Test
	public void  greetShouldReturnValidOutput(String name) {
		GreetingService greetingService=new GreetingServiceImpl();
		String result=((GreetingService) greetingService).greet("Gourav");
		Assertions.assertNotNull(result);
		Assertions.assertEquals("Hello Gourav", result);
	}

}
