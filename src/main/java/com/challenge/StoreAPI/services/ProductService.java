package com.challenge.StoreAPI.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.StoreAPI.models.Product;
import com.challenge.StoreAPI.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> listAll() {
		return productRepository.findAll();
	}
	
	public void save(Product product) {
		productRepository.save(product);
	}
	
	public Product get(int id) {
		return productRepository.findById(id).get();
	}
	
	public List<Product> getByName(String name) {
		return productRepository.findByNameContaining(name);
	}
	
	public List<Product> getByProductCategoryId(int productCategoryId) {
		return productRepository.findByProductCategoryId(productCategoryId);
	}
	
	public List<Product> findByScore(float score) {
		return productRepository.findByScore(score);
	}
	
	public void delete(int id) {
		productRepository.deleteById(id);
	}
}
