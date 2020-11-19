package com.challenge.StoreAPI.Product;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.StoreAPI.Sale.Sale;
import com.challenge.StoreAPI.Sale.SaleService;


@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SaleService saleService;
	
	
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
