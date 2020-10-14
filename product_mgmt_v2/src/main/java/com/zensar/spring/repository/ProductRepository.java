package com.zensar.spring.repository;

import java.util.List;

import com.zensar.model.Product;

public interface ProductRepository {
	public int insertProduct(Product product);

	public List<Product> getAllProducts();

	public void deleteProduct(final int productId);

	public Product updateProduct(Product product);

	public Product getParticularProduct(int productId);
	public Product getParticularProductByName(String productName);
}
