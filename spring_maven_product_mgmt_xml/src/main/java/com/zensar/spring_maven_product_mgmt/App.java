package com.zensar.spring_maven_product_mgmt;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.beans.Product;
import com.zensar.service.ProductService;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		ProductService service = context.getBean("service", ProductService.class);

		/*
		 * //Insertion
		 * 
		 * Product product=new Product(20,"KeyBoard", 1300);
		 * service.insertProduct(product);
		 */

		// Retrival

		List<Product> products = service.getAllProducts();

		for (Product product : products) {
			System.out.println(product);
		}

		/*
		 * //Deletion
		 * 
		 * service.deleteProduct(17);
		 */

		/*
		 * Updation
		 * 
		 * 
		 * service.updateProduct(15, "Apple tab", 80000);
		 */
	}
}
