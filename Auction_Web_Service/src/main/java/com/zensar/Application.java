package com.zensar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zensar.model.Bid;
import com.zensar.model.Product;
import com.zensar.model.ProductCategory;
import com.zensar.model.User;
import com.zensar.repository.BidRepository;
import com.zensar.repository.ProductCategoryRepository;
import com.zensar.repository.ProductRepository;
import com.zensar.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductCategoryRepository categoryRepository;
	@Autowired
	BidRepository bidRepository;

	@Value(value = "${spring.jpa.hibernate.ddl-auto}")
	String hbm2ddlStatus;

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(hbm2ddlStatus);
		/*
		 * User user = new User(); user.setFullName("Avina ");
		 * user.setEmail("abc@xyz.com"); user.setMobileNo("9907710811");
		 * user.setPassword("12345678"); user.setUserProfile("Bidder");
		 * 
		 * userRepository.save(user);
		 * 
		 * User user2 = new User(); user2.setFullName("Bhupesh");
		 * user2.setEmail("abcdef@xyz.com"); user2.setMobileNo("5557710811");
		 * user2.setPassword("12345678"); user2.setUserProfile("Bidder");
		 * 
		 * userRepository.save(user2);
		 * 
		 * ProductCategory category1 = new ProductCategory();
		 * category1.setProductCategoryName("Traditional");
		 * 
		 * ProductCategory category2 = new ProductCategory();
		 * category2.setProductCategoryName("Western");
		 * 
		 * categoryRepository.save(category1); categoryRepository.save(category2);
		 * 
		 * Product product1 = new Product(); product1.setProductName("MyArt");
		 * product1.setProductDetails("Good Painting"); product1.setBidAmount(1500);
		 * product1.setUser(user); product1.setProductCategory(category1);
		 * 
		 * Product product2 = new Product(); product2.setProductName("MyArt 2");
		 * product2.setProductDetails("Good Painting 2"); product2.setBidAmount(1505);
		 * product2.setUser(user); product2.setProductCategory(category2);
		 * 
		 * productRepository.save(product1); productRepository.save(product2);
		 * 
		 * Bid bid1 = new Bid(); bid1.setBidAmount(1002); bid1.setProduct(product2);
		 * bid1.setUser(user);
		 * 
		 * bidRepository.save(bid1);
		 * 
		 * Bid bid2 = new Bid(); bid2.setBidAmount(2050); bid2.setProduct(product1);
		 * bid2.setUser(user2);
		 * 
		 * bidRepository.save(bid2);
		 * 
		 * Bid bid3 = new Bid(); bid3.setBidAmount(1050); bid3.setProduct(product2);
		 * bid3.setUser(user);
		 * 
		 * bidRepository.save(bid3);
		 * 
		 * Bid bid4 = new Bid(); bid4.setBidAmount(2100); bid4.setProduct(product1);
		 * bid4.setUser(user2);
		 * 
		 * bidRepository.save(bid4);
		 * 
		 * System.out.println("End of run Method..!!!");
		 * 
		 * if(bidRepository.getBidsByProductId(5).iterator().hasNext()) {
		 * System.out.println("Not Empty"); }else System.out.println(" Empty");
		 * 
		 * 
		 * System.out.println(userRepository.getByEmail("abcdef@xyz.com"));
		 */

		/*
		 * ProductCategory category1 = new ProductCategory();
		 * category1.setProductCategoryName("Traditional");
		 * 
		 * ProductCategory category2 = new ProductCategory();
		 * category2.setProductCategoryName("Western");
		 */
		/*
		 * String categories[] = { "Traditional", "Western", "Drawing", "Graphic",
		 * "Photography", "Sculpture", "Other" }; for (String s : categories) {
		 * ProductCategory p = new ProductCategory(); p.setProductCategoryName(s);
		 * categoryRepository.save(p); }
		 */

		// System.out.println(productRepository.getLatestProducts());

		// System.out.println(productRepository.getLiveProducts());

		// System.out.println(productRepository.getProductsByRange(1498, 1502));

		// System.out.println(productRepository.getProductsByCategory(4));
		/*-----------------------	Stored Procedure
		 * DELIMITER $$
		
		
			DROP PROCEDURE IF EXISTS `hibernate`.`getProductById` $$
		
			CREATE PROCEDURE `hibernate`.`getProductById`
		
			(IN in_id INT, OUT out_name VARCHAR(255),OUT out_id integer,OUT out_cost integer)
		
			BEGIN
		
			SELECT id, name, cost INTO out_id, out_name, out_cost
		
			FROM product_details
		
			WHERE id = in_id;
		
			END $$
		
		
			DELIMITER ;
		 ----------------------------------------------------*/

	}

}
