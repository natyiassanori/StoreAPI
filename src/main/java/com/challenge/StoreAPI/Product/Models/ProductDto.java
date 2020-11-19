package com.challenge.StoreAPI.Product.Models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String name;
	
	private String description;
	
	private Date creationDate;
	
	private double score;
	
	private int productCategoryId;
	
	public ProductDto() {
		
	}
	
	public ProductDto(Integer productId, String name, String description, Date creationDate, float score, int productCategoryId) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.description = description;
		this.productCategoryId = productCategoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
}
