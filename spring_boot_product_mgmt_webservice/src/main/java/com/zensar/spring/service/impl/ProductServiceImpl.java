package com.zensar.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zensar.spring.models.Product;
import com.zensar.spring.repository.ProductRepository;
import com.zensar.spring.service.ProductService;

@Service
@CacheConfig(cacheNames = "products")
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository repositoryImpl;

	@Override
	//@Cacheable()
	public Iterable<Product> getAllProducts() {
		System.out.println("Cache Checking 2");
		return repositoryImpl.findAll();
	}

	@Override
	public Product getProduct(int productId) {
		return repositoryImpl.findById(productId).get();
	}

	@Override
	public Product insertProduct(Product product) {
		return repositoryImpl.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		 repositoryImpl.deleteById(productId);;
	}

	@Override
	public void updateProduct(Product updatedProduct) {
		int deleteId=updatedProduct.getProductId();
		repositoryImpl.deleteById(deleteId);
		repositoryImpl.save(updatedProduct);
		
	}

	@Override
	public List<Product> getByProductName(String productName) {
		return repositoryImpl.giveMeProductByName(productName);
	}
	
}
