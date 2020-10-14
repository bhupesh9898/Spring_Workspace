package com.zensar.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
	
	public Product(String productName, int productCost) {
		super();
		this.productName = productName;
		this.productCost = productCost;
	}

	private int productId;
	
	private String productName;
	
	private int productCost;
	
	
	
}
