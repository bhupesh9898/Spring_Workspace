package com.zensar.spring.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zensar.model.Product;
import com.zensar.spring.repository.ProductRepository;

import lombok.Getter;
import lombok.Setter;
	// Using Hibernate
@Repository
@Setter
@Getter
public class ProductRepositoryImpl3  implements ProductRepository {

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
		Product product2=session1.get(Product.class, product.getProductId());
		t1.commit();
		session1.close();
		System.out.println(product2);
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


	public Product getParticularProduct(int productId) {
		Session session = getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Product product = session.get(Product.class, productId);
		t.commit();
		session.close();
		return product;
		
	}

	public Product updateProduct(Product product) {
		Session session = getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("update Product set name= :productName ,cost= :productCost where id= :productId");
		query.setParameter("productName", product.getProductName());
		query.setParameter("productCost", product.getProductCost());
		query.setParameter("productId", product.getProductId());
		query.executeUpdate();
		t.commit();
		session.close();
		
		Session session1 = getSessionFactory().openSession();
		Transaction t1 = session1.beginTransaction();
		Product product2=session1.get(Product.class, product.getProductId());
		t1.commit();
		session1.close();
		System.out.println(product2);
		return product2;
		
		
	}

	@Override
	public Product getParticularProductByName(String productName) {
		Session session = getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("productName", productName));
		Product product=(Product)criteria.uniqueResult();
		System.out.println("Test 2 "+product);
		return product;
	}

}
