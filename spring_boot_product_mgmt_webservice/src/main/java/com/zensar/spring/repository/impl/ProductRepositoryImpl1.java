/*
 * package com.zensar.spring.repository.impl;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.stereotype.Repository;
 * 
 * import com.zensar.spring.models.Product; import
 * com.zensar.spring.repository.ProductRepository;
 * 
 * @Repository public class ProductRepositoryImpl1 implements ProductRepository
 * {
 * 
 * List<Product> products = new ArrayList<Product>();
 * 
 * public ProductRepositoryImpl1() { products.add(new Product(101, "Bottle",
 * 45)); products.add(new Product(102, "Cooler", 4500)); products.add(new
 * Product(103, "Fan", 1200)); products.add(new Product(104, "Mouse", 850)); }
 * 
 * @Override public List<Product> getAllProducts() {
 * System.out.println("Test of getAll"); return products; }
 * 
 * @Override public Product getProduct(int productId) { for(Product
 * product:products) { if(product.getProductId()==productId) { return product; }
 * } return null; }
 * 
 * @Override public boolean insertProduct(Product product) { return
 * products.add(product); }
 * 
 * @Override public boolean deleteProduct(int productId) { for(Product
 * product:products) { if(product.getProductId()==productId) { return
 * products.remove(product); } } return false; }
 * 
 * @Override public void updateProduct(Product updatedProduct) { for(Product
 * product:products) { if(product.getProductId()==updatedProduct.getProductId())
 * { product.setProductId(updatedProduct.getProductId());
 * product.setProductName(updatedProduct.getProductName());
 * product.setProductCost(updatedProduct.getProductCost()); } } }
 * 
 * }
 */