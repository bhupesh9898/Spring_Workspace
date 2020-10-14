package com.zensar.spring.repository.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.zensar.model.Product;
import com.zensar.spring.repository.ProductRepository;

//Using JDBC Template

@Repository
public class ProductRepositoryImpl2 implements ProductRepository {
	@Autowired
	private JdbcTemplate template;

	public int insertProduct(final Product product) {

		String sql = "insert into product2 (name,cost) values (?,?)";
		template.execute(sql, new PreparedStatementCallback<Product>() {

			public Product doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, product.getProductName());
				ps.setInt(2, product.getProductCost());
				ps.execute();

				return new Product();
			}
		});

		System.out.println("Product Inserted Successfully..!!!!!! ");
		sql = "Select id from product2 where name='" + product.getProductName() + "' and cost="
				+ product.getProductCost() + " ;";
		return template.query(sql, new ResultSetExtractor<Integer>() {
			int productId = 0;

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					productId = rs.getInt(1);
				}
				return productId;
			}
		});
	}

	public void deleteProduct(final int productId) {
		String sql = "delete from product2 where id=? ";
		template.execute(sql, new PreparedStatementCallback<Product>() {

			public Product doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, productId);
				ps.execute();
				return new Product();
			}
		});
	}

	public Product updateProduct(final Product product) {
		String sql = "update product2 set name=? ,cost=? where id=? ";
		return template.execute(sql, new PreparedStatementCallback<Product>() {

			public Product doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, product.getProductName());
				ps.setInt(2, product.getProductCost());
				ps.setInt(3, product.getProductId());
				ps.execute();
				return product;
			}
		});

	}

	public Product getParticularProduct(final int productId) {

		return template.query("Select * from product2 where id=" + productId + ";", new ResultSetExtractor<Product>() {

			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Product product = new Product();
					product.setProductId(rs.getInt(1));
					product.setProductName(rs.getString(2));
					product.setProductCost(rs.getInt(3));
					System.out.println(product);
					return product;
				}
				return null;
			}
		});

	}

	public List<Product> getAllProducts() {

		return template.query("Select * from product2 ", new ResultSetExtractor<List<Product>>() {

			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Product> products = new ArrayList<Product>();

				while (rs.next()) {
					Product product = new Product();
					product.setProductId(rs.getInt(1));
					product.setProductName(rs.getString(2));
					product.setProductCost(rs.getInt(3));
					products.add(product);
				}
				return products;
			}
		});

	}

}
