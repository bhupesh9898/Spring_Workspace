package com.zensar;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication()
public class EmployeeWebServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EmployeeWebServiceApplication.class, args);
		new SpringApplicationBuilder(EmployeeWebServiceApplication.class)
		.properties("server.port:8080").build().run(args);
	}

}
