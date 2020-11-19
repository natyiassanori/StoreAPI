package com.challenge.StoreAPI.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.StoreAPI.Product.Models.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	public List<Product> findByNameContaining(String name);
	
	public List<Product> findByProductCategoryId(int productCategoryId);
	
	public List<Product> findByScore(float score);
}
