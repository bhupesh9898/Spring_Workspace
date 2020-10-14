package com.zensar.repository;

import java.util.List;

import com.zensar.beans.Product;

public interface ProductRepository {
	public int insertProduct(Product product);
	public List<Product> getAllProducts();
	public void deleteProduct(final int productId);
	public void updateProduct(final int productId, final String productName, final int productCost) ;

}
