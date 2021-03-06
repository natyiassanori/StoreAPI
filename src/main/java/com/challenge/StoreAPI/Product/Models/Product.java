package com.challenge.StoreAPI.Product.Models;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
	
	private double score;
	
	private int productCategoryId;
	
	public Product() {
		
	}
	
	public Product(String name, String description, Date creationDate, double score, int productCategoryId) {
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}		
	
	public long getDaysOfExistence() {
				
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		
		Calendar productCreation = Calendar.getInstance();
		productCreation.setTime(creationDate);
		productCreation.set(Calendar.HOUR_OF_DAY, 0);
		
		long diffInMillies = today.getTimeInMillis() - productCreation.getTimeInMillis();
	    
		//when a product is created on the current date, I consider it to be 1 day old. So I added 1 day, because in this case
		//the difference between current date and product creation date is 0
		return TimeUnit.MILLISECONDS.toDays(diffInMillies) + 1;
	}
	
}
