package com.challenge.StoreAPI.NewsPerCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news_per_product_category")
public class NewsPerProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int newsPerProductCategoryId;
	
	private int productCategoryId;
	
	private int newsCount;	
	
	public NewsPerProductCategory() {
		
	}
	
	public NewsPerProductCategory(int productCategoryId, int newsCount) {
		this.productCategoryId = productCategoryId;
		this.newsCount = newsCount;
	}

	public int getNewsPerProductCategoryId() {
		return newsPerProductCategoryId;
	}

	public void setNewsPerProductCategoryId(int newsPerProductCategoryId) {
		this.newsPerProductCategoryId = newsPerProductCategoryId;
	}

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public int getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}
	
	
}
