package com.zensar.spring.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.spring.models.Product;
import com.zensar.spring.service.ProductService;

@RestController
@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
@CacheConfig(cacheNames ="products")
public class ProductController {
	
	private static Logger logger=LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService service;

	// @RequestMapping(value="/product",method = RequestMethod.GET)
	@GetMapping(value = "/product")
	@Cacheable()
	public Iterable<Product> getAllProducts() {
		System.out.println("Checking for cache...");
		return service.getAllProducts();
	}

	@GetMapping("/product/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {
		return service.getProduct(productId);

	}

	@PostMapping("/product")
	public ResponseEntity<?> insertProduct(@RequestBody Product product) {
		 service.insertProduct(product);
		 return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/product/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {
		service.deleteProduct(productId);
	}

	@PatchMapping("/product")
	public void updateProduct(@RequestBody Product updatedProduct) {
		service.updateProduct(updatedProduct);

	}
	@GetMapping("/product/byname/{productName}")
	public List<Product> getByProductName(@PathVariable ("productName")String productName) {
		return service.getByProductName(productName);
	}

}
