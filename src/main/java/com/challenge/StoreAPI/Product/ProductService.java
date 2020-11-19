package com.challenge.StoreAPI.Product;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.StoreAPI.NewsPerCategory.NewsPerProductCategoryService;
import com.challenge.StoreAPI.Product.Models.Product;
import com.challenge.StoreAPI.Product.Models.ProductDto;
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
	
	private ProductMapper productMapper = new ProductMapper();
		
	
	public List<ProductDto> listAll() {
		
		List<Product> products = productRepository.findAll();
		
		List<ProductDto> productDtos = productMapper.ConvertProductListToProductDtoList(products);
		
		return productDtos;
	}

	
	
	public ProductDto getById(int id) {
		
		Product product = productRepository.findById(id).get();
		
		return productMapper.convertProductToProductDto(product);
		
	}
	
	public Product getProductById(int id) {
		
		return productRepository.findById(id).get();		
	}
	
	public List<ProductDto> getByName(String name) {
		
		List<Product> products = productRepository.findByNameContaining(name);
		
		List<ProductDto> productDtos = productMapper.ConvertProductListToProductDtoList(products);
		
		return productDtos;
	}
	
	public List<ProductDto> getByNameOrderByScoreDescending(String name) {
		
		List<ProductDto> productDtos = getByName(name);
		
		productDtos.sort(Comparator.comparing(ProductDto::getScore));
		
		return productDtos;
	}
	
	public List<ProductDto> getByProductCategoryId(int productCategoryId) {
		
		List<Product> products = productRepository.findByProductCategoryId(productCategoryId);
		
		List<ProductDto> productDtos = productMapper.ConvertProductListToProductDtoList(products);
		
		return productDtos;
	}
	
	public List<ProductDto> findByScore(float score) {
		
		List<Product> products = productRepository.findByScore(score);
		
		List<ProductDto> productDtos = productMapper.ConvertProductListToProductDtoList(products);
		
		return productDtos;
	}
	
	
	public void create(ProductDto productDto) {
		
		Product product = productMapper.convertProductDtoToProduct(productDto);
		
		product.setCreationDate(new Date());
		product.setScore(0);
		
		save(product);
		
	}
	
	public void update(ProductDto productDto, int id) {
		
		Product product = productMapper.convertProductDtoToProduct(productDto);
		
		product.setProductId(id);
		
		ProductDto existingProduct = getById(id);
		
		product.setCreationDate(existingProduct.getCreationDate());
		product.setScore(existingProduct.getScore());
		
		save(product);
		
	}
	
	
	public void save(Product product) {
		
		productRepository.save(product);
		
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
