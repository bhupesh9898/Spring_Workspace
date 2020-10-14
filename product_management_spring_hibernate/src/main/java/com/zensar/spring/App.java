package com.zensar.spring;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.spring.model.Product;
import com.zensar.spring.service.ProductService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService service = context.getBean("service", ProductService.class);

		String response = "no";
		int  choice;

		System.out.println("Welcome To Product Management..");

		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Insert Product");
			System.out.println("2. Display All Product");
			System.out.println("3. Get Particular Product");
			System.out.println("4. Delete Particular Product");
			System.out.println("5. Update Product");
			System.out.println("Please Enter your Choice ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Please Enter Product Name : ");
				String productName = sc.next();

				System.out.println("Please Enter Product Cost : ");
				int productCost = sc.nextInt();

				int id=service.insertProduct(new Product(productName, productCost));

				System.out.println("Your Product is Registered Successfully with Id : "+id);

				System.out.println("Would you like to continue ? [Yes/No] ");
				response = sc.next();

				if (!response.equalsIgnoreCase("Yes")) {
					System.out.println("Thank You for using our services..!!!!");
				}
				break;
			case 2:

				List<Product> products = service.getAllProducts();
				for (Product p : products) {
					System.out.println(p);
				}
				break;

			case 3:

				System.out.println("Enter Product ID : ");
				int productSearchId = sc.nextInt();

				Product product = service.getParticularProduct(productSearchId);
				System.out.println(product);
				break;
			case 4:
				System.out.println("Enter Product ID : ");
				int productDeleteId = sc.nextInt();
				service.deleteProduct(productDeleteId);

				break;
			case 5:
				System.out.println("Enter Product ID you want to update : ");
				int productUpdateId = sc.nextInt();
				System.out.println("Enter Product Name you want to update : ");
				String productUpdateName = sc.next();
				System.out.println("Enter Product Cost you want to update : ");
				int productUpdateCost = sc.nextInt();
				
				service.updateProduct(productUpdateId, productUpdateName, productUpdateCost);
				break;

			default:
				System.out.println("Sorry Invalid Choice....!!!!!!");
			}
		} while (response.equalsIgnoreCase("Yes"));

	}
}
