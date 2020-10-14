package com.zensar.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.beans.Product;
@Repository
public class ProductRepositoryImpl1 implements ProductRepository {

	/*
	 * @Autowired private JdbcTemplate template;
	 */
	@Autowired
	NamedParameterJdbcTemplate template;
	

	@Value("${hello}")
	String hello;
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
/*
	//Using JDBCTemplate
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
	*/
	public int insertProduct(Product product) {
		String sql = "insert into product1 values(:productId ,:productName, :productCost)";
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("productId", product.getProductId());
		map.put("productName", product.getProductName());
		map.put("productCost", product.getProductCost());
		
		template.execute(sql, map, new PreparedStatementCallback<Integer>() {

			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				
				return ps.executeUpdate();
			}
		});
		System.out.println("Product Inserted Successfully..!!!!!! ");
		System.out.println(hello);
		return 0;
	}
	
	
	
/*
 * Using ResultSetExtractor
 * 
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
	*/
	
	/*
	//Using RowMapper AnonymousClass
	public List<Product> getAllProducts() {
		return template.query("Select * from product1 ",new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductCost(rs.getInt(3));
				return product;
			}
		}) ;
		
	}
*/
	
	//Using MyRowMapperClass 
	public List<Product> getAllProducts() {
		return template.query("Select * from product1 ",new MyRowMapper());
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
