package com.zensar.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.zensar.model.Product;
import com.zensar.spring.repository.ProductRepository;
import com.zensar.spring.service.ProductService;

import lombok.Getter;
import lombok.Setter;



@Service
public class ProductServiceImpl1 implements ProductService {
	@Value("${impl.name}")
	private  String implName;
	
	//@Autowired
	//@Qualifier("productRepositoryImpl3")
	private ProductRepository repositoryImpl;
	
	
	public ProductRepository getRepositoryImpl() {
		return repositoryImpl;
	}
	
	@Autowired
	public void setRepositoryImpl(ApplicationContext context) {
		repositoryImpl = (ProductRepository)context.getBean(implName);
	}

	public int insertProduct(Product product) {
		return repositoryImpl.insertProduct(product);
	}

	public void deleteProduct(int productId) {
		repositoryImpl.deleteProduct(productId);
	}

	public Product getParticularProduct(int productId) {
		return repositoryImpl.getParticularProduct(productId);
	}
	
	public Product updateProduct(Product product) {
		return repositoryImpl.updateProduct(product);
	}

	public List<Product> getAllProducts() {
		return repositoryImpl.getAllProducts();
	}

	@Override
	public Product getParticularProductByName(String productName) {
		
		return repositoryImpl.getParticularProductByName(productName);
	}

}
