package com.zensar.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.spring.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	//List<Product> getByProductName(String productName);
	
	//List<Product> giveMeProduct(String productName);
	@Query("from Product P where P.productName=:name")
	List<Product> giveMeProductByName(@Param ("name")String productName);
}
