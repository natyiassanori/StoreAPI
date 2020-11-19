package com.challenge.StoreAPI.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.challenge.StoreAPI.Product.Models.Product;
import com.challenge.StoreAPI.Product.Models.ProductDto;

public class ProductMapper {

	
	public ProductMapper() {
		
	}
	
	public Product convertProductDtoToProduct(ProductDto productDto) {
				
		Product product = new Product();
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		product.setProductCategoryId(productDto.getProductCategoryId());
		
		return product;	
		
	}
	
	public ProductDto convertProductToProductDto(Product product){
		
		ProductDto productDto = new ProductDto();
		productDto.setProductId(product.getProductId());
		productDto.setDescription(product.getDescription());
		productDto.setName(product.getName());
		productDto.setProductCategoryId(product.getProductCategoryId());
		productDto.setScore(product.getScore());	
		productDto.setCreationDate(product.getCreationDate());

		return productDto;	
		
	}
	
	public List<ProductDto> ConvertProductListToProductDtoList(List<Product> products){
		
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		
		for (Product product : products) {
			productDtos.add(convertProductToProductDto(product));
		}
		
		return productDtos;
	}	
}
