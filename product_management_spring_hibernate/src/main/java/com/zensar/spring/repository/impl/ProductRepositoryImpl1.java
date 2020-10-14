package com.zensar.spring.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zensar.spring.model.Product;
import com.zensar.spring.repository.ProductRepository;

import lombok.Getter;
import lombok.Setter;

@Repository
@Setter
@Getter
public class ProductRepositoryImpl1 implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public int insertProduct(Product product) {
		Session session = getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(product);
		t.commit();
		session.close();
		
		Session session1 = getSessionFactory().openSession();
		Transaction t1 = session1.beginTransaction();
		Query query = session1.createQuery("from Product where id =:productId ");
		query.setParameter("productId", product.getProductId());
		Product product2=(Product)query.uniqueResult();
		t1.commit();
		session1.close();
		return product2.getProductId();
	}

	public List<Product> getAllProducts() {
		Session session = getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> products;
		products = query.list();
		return products;
	}

	public void deleteProduct(int productId) {
		Session session = getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("delete from Product where id =:productId");
		query.setParameter("productId", productId);
		query.executeUpdate();
		System.out.println("Product Deleted Successfully..!!!");
		t.commit();
		session.close();
	}

	public void updateProduct(int productId, String productName, int productCost) {
		Session session = getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("update Product set name= :productName ,cost= :productCost where id= :productId");
		query.setParameter("productName", productName);
		query.setParameter("productCost", productCost);
		query.setParameter("productId", productId);
		query.executeUpdate();
		System.out.println("Product Updated Successfully..!!!");
		t.commit();
		session.close();

	}

	public Product getParticularProduct(int productId) {
		Session session = getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Product product = session.get(Product.class, productId);
		t.commit();
		session.close();
		return product;
		
	}

}
