package com.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class WelcomeController {
	
	@RequestMapping("/welcome/{fname}/{lname}")
	public String sayWelcome(@PathVariable("fname")String fname,
			@PathVariable("lname")String lname) {
		System.out.println("Test : "+fname+" "+lname);
		return "Welcome";	//logical name of view
	}
	
	@RequestMapping("/welcome1/{name}")
	public ModelAndView sayWelcome1(@PathVariable("name")String name) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("name", name);
		modelAndView.setViewName("Welcome1");
		return modelAndView;
		
	}
	@RequestMapping("/test/{num}")
	public String sayTest(@PathVariable("num")int num1,HttpServletRequest req) {
		
		req.setAttribute("num", num1);
		return "test";
	}

}
