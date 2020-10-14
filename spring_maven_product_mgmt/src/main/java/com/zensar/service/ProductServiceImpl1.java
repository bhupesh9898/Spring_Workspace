package com.zensar.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.beans.Product;
import com.zensar.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl1 implements ProductService {

	private ProductRepository repositoryImpl;

	public ProductRepository getRepositoryImpl() {
		return repositoryImpl;
	}

	@Autowired
	public void setRepositoryImpl(ProductRepository repositoryImpl) {
		this.repositoryImpl = repositoryImpl;
	}

	public int insertProduct(Product product) {

		return repositoryImpl.insertProduct(product);
	}
	@PostConstruct
	public void myInit() {
		System.out.println("inside init");
	}
	@PreDestroy
	public void myDestroy() {
		System.out.println("inside destroy");
	}

}
