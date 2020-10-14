package com.zensar.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.zensar.beans.Product;

public class MyRowMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product=new Product();
		product.setProductId(rs.getInt(1));
		product.setProductName(rs.getString(2));
		product.setProductCost(rs.getInt(3));
		return product;
	}

}
