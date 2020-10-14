package com.zensar.repository;

import org.springframework.stereotype.Repository;

import com.zensar.beans.Product;
@Repository
public class ProductRepositoryImpl1 implements ProductRepository{

	
	Product[] products=new Product[10];
	int productId=100,index=0;
	public int insertProduct(Product product) {
		products[index++]=product;
		return productId++;
	}

}
