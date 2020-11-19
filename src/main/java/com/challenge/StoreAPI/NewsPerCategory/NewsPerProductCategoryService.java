package com.challenge.StoreAPI.NewsPerCategory;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.challenge.StoreAPI.Product.ProductService;
import com.challenge.StoreAPI.ProductCategory.ProductCategory;
import com.challenge.StoreAPI.ProductCategory.ProductCategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class NewsPerProductCategoryService {

	private final String BASE_URL = "https://newsapi.org/v2/top-headlines";
	private final String API_KEY = "e0d4e56650ee4ef69299d3ccb4f84061";
	private final String COUNTRY = "us";
		
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private NewsPerCategoryRepository newsPerCategoryRepository;
	
	public int getNewsCountByProductCategoryId(int productCategoryId) {
		
		return newsPerCategoryRepository.findByProductCategoryId(productCategoryId).getNewsCount();
		
	}
	
	
	public String updateNewsByProductCategory() {
				
		List<ProductCategory> productCategories = productCategoryService.getAll();
		
		for (ProductCategory productCategory : productCategories) {					
			
			Client client = ClientBuilder.newBuilder().build();
			WebTarget target = client.target(buildURL(productCategory.getDescription()));
			Response response = target.request().get();
			String value = response.readEntity(String.class);
						
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode;
			
			try {
				jsonNode = objectMapper.readTree(value);
				String newsCount = jsonNode.get("totalResults").asText();
				
				
				NewsPerProductCategory newsPerProductCategory = null;
				boolean newsPerProductCategoryExists = newsPerCategoryRepository.existsByProductCategoryId(productCategory.getProductCategoryId());
				
				if(newsPerProductCategoryExists) {
					newsPerProductCategory = newsPerCategoryRepository.findByProductCategoryId(productCategory.getProductCategoryId());
					newsPerProductCategory.setNewsCount(Integer.parseInt(newsCount));
				} else {
					newsPerProductCategory = new NewsPerProductCategory(productCategory.getProductCategoryId(), Integer.parseInt(newsCount));
				}
				
				newsPerCategoryRepository.save(newsPerProductCategory);	
				
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			response.close(); 
		}       
		
		productService.updateProductScores();
         
        return "ok";
	}
	
	private String buildURL(String productCategoryDescription) {
		return BASE_URL + "?country=" + COUNTRY + "&category=" + productCategoryDescription + "&apiKey=" + API_KEY;
	}
}
