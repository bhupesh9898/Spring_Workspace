package com.zensar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.model.Product;
import com.zensar.model.ProductCategory;
import com.zensar.repository.ProductRepository;
import com.zensar.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void updateProduct(Product updatedProduct) {
		
		productRepository.deleteById(updatedProduct.getProductId());
		productRepository.save(updatedProduct);
	}

	@Override
	public void createProduct(Product product) {
		productRepository.save(product);
		productRepository.createEvent();
	}


	@Override
	public Product getProductDetailsById(int productId) {
		return productRepository.findById(productId).get();	
	}

	@Override
	public Iterable<Product> getLiveProducts() {
		return productRepository.getLiveProducts();
	}

	@Override
	public Iterable<Product> getProductsByRange(int priceLowerLimit, int priceUpperLimit) {
		return productRepository.getProductsByRange(priceLowerLimit, priceUpperLimit);
	}

	@Override
	public Iterable<Product> getProductsByCategory(int categoryId) {
		return productRepository.getProductsByCategory(categoryId);
	}

	@Override
	public Iterable<Product> getLatestProducts() {
		return productRepository.getLatestProducts();
	}

}
