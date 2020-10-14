package com.zensar.spring.service;

import java.util.List;

import com.zensar.spring.models.Product;

public interface ProductService {
	public Iterable<Product> getAllProducts();
	public Product getProduct(int productId);
	List<Product> getByProductName(String productName);
	public Product insertProduct(Product product);
	public void deleteProduct(int productId);
	public void updateProduct(Product updatedProduct);
}
