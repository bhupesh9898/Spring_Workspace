package com.zensar.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.beans.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*
		 * Resource resource = new FileSystemResource("applicationContext.xml");
		 * BeanFactory beanFactory = new XmlBeanFactory(resource);
		 */

		/*
		 * Student student = (Student) beanFactory.getBean("student");
		 * System.out.println(student);
		 * 
		 * Student student2 = beanFactory.getBean(Student.class, "student");
		 * System.out.println(student2);
		 */
		Student student = context.getBean(Student.class);
		System.out.println(student);
	}
}
