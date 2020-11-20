package com.challenge.StoreAPI.Product.Models;

import java.util.Date;
import java.util.List;

public class ProductRanking {

	Date searchDate;
	
	String searchName;
	
	String searchCategory;
	
	int productsCount;
	
	List<ProductDto> products;
	
	public ProductRanking(Date searchDate, String searchName, String searchCategory, List<ProductDto> productDtos) {
		this.searchDate = searchDate;
		this.searchName = searchName;
		this.searchCategory = searchCategory;
		this.products = productDtos;
		this.productsCount = products.size();
	}

	public Date getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> productDtos) {
		this.products = productDtos;
	}

	public int getProductsCount() {
		return productsCount;
	}

	public void setProductsCount(int productsCount) {
		this.productsCount = productsCount;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}
	
	
	
}
