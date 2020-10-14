package com.zensar.spring_maven_product_mgmt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.beans.Product;
import com.zensar.service.ProductService;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

		ProductService service=context.getBean("productService",ProductService.class);
		Product product=new Product("Phone", 500);
		System.out.println("Product inserted with id : "+service.insertProduct(product));
	}
}
