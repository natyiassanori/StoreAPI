package com.challenge.StoreAPI.Product;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String name;
	
	private String description;
	
	private Date creationDate;
	
	private float score;
	
	private int productCategoryId;
	
	public Product() {
		
	}
	
	public Product(Integer productId, String name, String description, Date creationDate, float score, int productCategoryId) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.score = score;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryoId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}	
	
}
