package com.zensar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.beans.Student;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*
		 * Resource resource = new FileSystemResource("applicationContext.xml");
		 * BeanFactory beanFactory = new XmlBeanFactory(resource);
		 * 
		 */
		Student student2 = context.getBean(Student.class, "student");
		System.out.println(student2);
		context.registerShutdownHook();
	}
}
