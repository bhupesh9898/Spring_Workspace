package com.zensar.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.spring.model.Product;
import com.zensar.spring.repository.ProductRepository;
import com.zensar.spring.service.ProductService;

import lombok.Getter;
import lombok.Setter;
@Service("service")
@Setter
@Getter
public class ProductServiceImpl1 implements ProductService {
	@Autowired
	private ProductRepository repositoryImpl;
	
	
	public int insertProduct(Product product) {
		
		return repositoryImpl.insertProduct(product);
	}

	public List<Product> getAllProducts() {
		return repositoryImpl.getAllProducts();
	}

	public void deleteProduct(int productId) {
		repositoryImpl.deleteProduct(productId);
		
	}

	public void updateProduct(int productId, String productName, int productCost) {
		repositoryImpl.updateProduct(productId, productName, productCost);
		
	}

	public Product getParticularProduct(int productId) {
		return repositoryImpl.getParticularProduct(productId);
	}

}
