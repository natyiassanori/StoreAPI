package com.challenge.StoreAPI.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{

	public List<ProductCategory> findByDescriptionContaining(String name);
	
}
