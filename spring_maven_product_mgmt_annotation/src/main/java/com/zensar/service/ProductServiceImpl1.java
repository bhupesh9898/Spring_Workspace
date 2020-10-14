package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zensar.beans.Product;
import com.zensar.repository.ProductRepository;

@Service("service")
public class ProductServiceImpl1 implements ProductService {
	@Autowired
	@Qualifier("productRepositoryImpl1")
	private ProductRepository repositoryImpl;

	public ProductRepository getRepositoryImpl() {
		return repositoryImpl;
	}
	public void setRepositoryImpl(ProductRepository repositoryImpl) {
		this.repositoryImpl = repositoryImpl;
	}
	public int insertProduct(Product product) {

		return repositoryImpl.insertProduct(product);
	}

	public ProductServiceImpl1(ProductRepository repositoryImpl) {
		super();
		this.repositoryImpl = repositoryImpl;
	}
	public ProductServiceImpl1() {
		super();
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

}
