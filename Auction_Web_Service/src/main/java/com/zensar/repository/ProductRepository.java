package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("FROM Product P WHERE P.status = 'On'")
	Iterable<Product> getLiveProducts();
	
	@Query("FROM Product P WHERE P.bidAmount >= :priceLowerLimit and P.bidAmount <= :priceUpperLimit")
	Iterable<Product> getProductsByRange(@Param("priceLowerLimit") int priceLowerLimit,@Param("priceUpperLimit") int priceUpperLimit);
	
	@Query("FROM Product P WHERE P.productCategory.productCategoryId = :productCategoryId")
	Iterable<Product> getProductsByCategory(@Param("productCategoryId")int categoryId);

	@Query("FROM Product P WHERE P.status = 'On' ORDER BY P.productId DESC")
	Iterable<Product> getLatestProducts();
	
	@Query(value="CREATE EVENT IF NOT EXISTS auto_set_status" + 
			"   ON SCHEDULE EVERY 5 SECOND DO" + 
			"   UPDATE auctiondemo.product SET status = 'Off' "+
			"	WHERE SYSDATE() >= closing_date AND status ='On';", nativeQuery=true)
			public void createEvent();
	
	//boolean productExistBy
}
