package com.zensar.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("/hello")
	public String sayHello() {
		return "welcome";
	}
}
