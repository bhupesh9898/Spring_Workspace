package com.zensar.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zensar.beans.Product;
@Repository
public class ProductRepositoryImpl2 implements ProductRepository {

	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

	}

	public void updateProduct(int productId, String productName, int productCost) {
		// TODO Auto-generated method stub

	}

}
