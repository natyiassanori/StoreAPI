package com.challenge.StoreAPI.Product.Models;

import java.util.Date;
import java.util.List;

public class ProductRanking {

	Date searchDate;
	
	String searchTerm;
	
	int productsCount;
	
	List<ProductDto> products;
	
	public ProductRanking(Date searchDate, String searchTerm, List<ProductDto> productDtos) {
		this.searchDate = searchDate;
		this.searchTerm = searchTerm;
		this.products = productDtos;
		this.productsCount = products.size();
	}

	public Date getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
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
	
	
}