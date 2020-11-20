package com.challenge.StoreAPI.ProductCategory;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductCategoryService {

	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	public List<ProductCategory> getAll(){
		
		return productCategoryRepository.findAll();
		
	}
	
	public ProductCategory getByProductCategoryId(int productCategoryId) {
		
		return productCategoryRepository.findById(productCategoryId).get();
		
	}
	
	public List<ProductCategory> getByProductCategoriesByDescription(String description) {
		
		return productCategoryRepository.findByDescriptionContaining(description);
		
	}
	
	public ProductCategory getByProductCategoryByDescription(String description) {
		
		return productCategoryRepository.findByDescription(description);
		
	}
	
	public boolean existsProductCategory(int productCategoryId) {
		
		return productCategoryRepository.existsById(productCategoryId);
		
	}	
}
