                                                                                                                                                                                                                                                                                                                                                               package com.zensar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Product_v2")
public class Product {
	@Id
	@Column(name = "id")
	private int productId;
	@Column(name = "name")
	private String productName;
	@Column(name = "cost")

	@Min(value = 10)
	private int productCost;
}
