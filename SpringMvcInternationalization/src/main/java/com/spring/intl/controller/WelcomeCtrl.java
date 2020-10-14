package com.spring.intl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeCtrl {

	@RequestMapping(value= "/init", method= RequestMethod.GET)
	public ModelAndView initView() {
		System.out.println("Handler method is called.");

		ModelAndView modelview = new ModelAndView();
		modelview.addObject("welcome_msg", "Spring Mvc Internationalization Example");		
		modelview.setViewName("welcome");
		return modelview;
	}
}