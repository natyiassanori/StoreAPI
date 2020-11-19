package com.challenge.StoreAPI.NewsPerCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsPerCategoryRepository extends JpaRepository<NewsPerProductCategory, Integer>{

	public boolean existsByProductCategoryId(int productCategoryId);
	
	public NewsPerProductCategory findByProductCategoryId(int productCategoryId);
	
}
