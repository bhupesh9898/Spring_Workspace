package com.zensar.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.zensar.spring.beans.Student;

public class App {
	public static void main(String[] args) {
		// ApplicationContext context=new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		Resource resource = new FileSystemResource("applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);

		Student student = (Student) beanFactory.getBean("student");
		System.out.println(student);

	}
}
