package com.challenge.StoreAPI.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	public List<Product> findByNameContaining(String name);
	
	public List<Product> findByProductCategoryId(int productCategoryId);
	
	public List<Product> findByScore(float score);
}
