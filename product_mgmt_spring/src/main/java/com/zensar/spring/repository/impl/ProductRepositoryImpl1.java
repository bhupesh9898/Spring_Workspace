package com.zensar.spring.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zensar.model.Product;
import com.zensar.spring.repository.ProductRepository;
			//Using Array
@Repository
public class ProductRepositoryImpl1 implements ProductRepository {

	Product[] products = new Product[10];
	private static int index = 0, id = 100;

	public int insertProduct(Product product) {
		products[index++] = product;
		product.setProductId(id++);
		return product.getProductId();
	}


	
	
	public void deleteProduct(int productId) {
		for (int i = 0; i < products.length; i++) {
			if (products[i].getProductId() == productId) {
				products[i] = null;
				System.out.println("Product deleted Successfully");
				break;
			}
		}

	}

	public Product updateProduct(Product product) {
		System.out.println("Product Updated Successfully Before...." + product.getProductId());
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				if (products[i].getProductId() == product.getProductId()) {
					products[i].setProductName(product.getProductName());
					products[i].setProductCost(product.getProductCost());
					System.out.println("Product Updated Successfully");
					return products[i];
				}
			}
		}
		return product;

	}

	public Product getParticularProduct(int productId) {
		for (int i = 0; i < products.length; i++) {
			if (products[i].getProductId() == productId) {
				return products[i];
			}
		}
		return null;
	}

	public List<Product> getAllProducts() {
		List<Product> products1=new ArrayList<Product>();
		for (int i = 0; i < products.length; i++) {
			if(products[i]!=null)
				products1.add(products[i]);
		}
		return products1;
	}

}
