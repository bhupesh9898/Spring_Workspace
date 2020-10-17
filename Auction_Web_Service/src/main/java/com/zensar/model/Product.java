package com.zensar.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Entity
@ToString
@Table(name = "product")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_details")
	private String productDetails;

	@Column(name = "bid_amount")
	private int bidAmount;

	@Column(name = "closing_date")
	private Timestamp closingDate;

	@Column(name = "status")
	private String status = "On";

	
	@OneToOne 
	@JoinColumn(name = "seller_id")
	private User user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_category_id", nullable = false)
	@JsonBackReference
	private ProductCategory productCategory;

	public Product() {
		
		LocalDateTime dateTime = LocalDateTime.now();
		dateTime = dateTime.plusDays(1);
		Timestamp closingDateTime = Timestamp.valueOf(dateTime);
		closingDate = closingDateTime;
	}
}
