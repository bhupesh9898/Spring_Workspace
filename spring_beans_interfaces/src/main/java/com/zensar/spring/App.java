package com.zensar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.beans.Shapeable;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*
		 * Resource resource = new FileSystemResource("applicationContext.xml");
		 * BeanFactory beanFactory = new XmlBeanFactory(resource);
		 * 
		 */
		Shapeable shape=context.getBean("circle",Shapeable.class);
		
		
		System.out.println(shape.area());
		


	}
}
