package com.zensar.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.zensar.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {

	public ProductRepositoryImpl1(JdbcTemplate template) {
		super();
		this.template = template;
	}

	private JdbcTemplate template;

	/*
	 * Without prepared statement
	 * 
	 * 
	 * public int insertProduct(Product product) { String
	 * sql="insert into product1 values ("+product.getProductId()+",'"+product.
	 * getProductName()+"',"+product.getProductCost()+");"; System.out.println(sql);
	 * template.execute(sql);
	 * System.out.println("Product Inserted Successfully..!!!!!! "); return 0; }
	 */
	public ProductRepositoryImpl1() {
		super();
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int insertProduct(final Product product) {
		String sql = "insert into product1 values (?,?,?)";
		template.execute(sql, new PreparedStatementCallback<Product>() {

			public Product doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, product.getProductId());
				ps.setString(2, product.getProductName());
				ps.setInt(3, product.getProductCost());
				ps.execute();

				return new Product();
			}
		});
		System.out.println("Product Inserted Successfully..!!!!!! ");
		return 0;
	}

	public List<Product> getAllProducts() {
		return template.query("Select * from product1 ", new ResultSetExtractor<List<Product>>() {

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

	public void deleteProduct(final int productId) {
		String sql = "delete from product1 where id=?;";
		template.execute(sql, new PreparedStatementCallback<Product>() {

			public Product doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, productId);

				ps.execute();

				return new Product();
			}
		});
		System.out.println("Product Deleted Successfully..!!!!!! ");
	}

	public void updateProduct(final int productId, final String productName, final int productCost) {
		String sql = "update product1 set productname=? ,productCost=? where id=?";
		template.execute(sql, new PreparedStatementCallback<Product>() {

			public Product doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				
				ps.setString(1, productName);
				ps.setInt(2,productCost);
				ps.setInt(3, productId);
				ps.execute();

				return new Product();
			}
		});
		System.out.println("Product Updated Successfully..!!!!!! ");

	}

}
