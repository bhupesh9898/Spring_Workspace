package com.zensar.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.zensar.spring.beans.Address;
import com.zensar.spring.beans.Employee;
//DemoConfig is equivalant to applicationContext.xml
@Configuration
@PropertySource("data.properties")
public class DemoConfig {
	@Value("${name}")
	String name;
	@Bean("employee")
	public Employee getEmployee() {
		System.out.println(name);
		return new Employee(1000, "DemoEmployee", 500,new Address(451263,"Indore","MP"));
	}
}
