package com.zensar.spring.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
//@NamedQuery(name = "Product.giveMeProduct", query = "from Product P where P.productName=?1")
//@NamedNativeQuery(name="Product.giveMeProductByName",query = "select * from Product where product_name=?1",resultClass = Product.class)
public class Product implements Serializable {
	@Id
	private int productId;
	private String productName;
	private int productCost;
}
