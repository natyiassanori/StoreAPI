package com.challenge.StoreAPI.Product;

import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.StoreAPI.NewsPerCategory.NewsPerProductCategoryService;
import com.challenge.StoreAPI.Sale.SaleService;


@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private NewsPerProductCategoryService newsPerProductCategoryService;
	
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
	
	public List<Product> getByNameOrderByScoreDescending(String name) {
		List<Product> products = getByName(name);
		products.sort(Comparator.comparing(Product::getScore));
		return products;
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
	
	public void updateProductScores() {
		
		List<Product> products = productRepository.findAll();
		
		for (Product product : products) {
			
			double ratingAverageOverThePastTwelveMonths = saleService.calculateRatingAverageOverThePastTwelveMonthsByProductId(product.getProductId());
			
			double salesPerProductExistenceDays = saleService.calculateSalesByProductExistingDays(product.getProductId());
			
			int newsCountByProductCategory = newsPerProductCategoryService.getNewsCountByProductCategoryId(product.getProductCategoryId());
			
			product.setScore(ratingAverageOverThePastTwelveMonths + salesPerProductExistenceDays + newsCountByProductCategory); 
			
			productRepository.save(product);
		}		
		
	}
	
	
}
