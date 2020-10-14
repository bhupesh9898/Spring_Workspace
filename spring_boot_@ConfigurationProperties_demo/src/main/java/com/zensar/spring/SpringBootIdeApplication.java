package com.zensar.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zensar.spring.model.User;

@SpringBootApplication
public class SpringBootIdeApplication implements CommandLineRunner {
	@Autowired
	private User user;
	public static void main(String[] args) {
	
		SpringApplication.run(SpringBootIdeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("User Name is : "+user.getUsername());
		System.out.println("User Password is : "+user.getPassword());
	}

}
