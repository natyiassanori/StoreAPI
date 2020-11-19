package com.challenge.StoreAPI.Product;

import java.util.ArrayList;
import java.util.List;

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
	
	public ProductDto convertProductToProductDto(Product product) {
		
		ProductDto productDto = new ProductDto();
		product.setDescription(product.getDescription());
		product.setName(product.getName());
		product.setProductCategoryId(product.getProductCategoryId());
		product.setCreationDate(product.getCreationDate());
		product.setScore(product.getScore());
		
		return productDto;	
		
	}
	
	public List<ProductDto> ConvertProductListToProductDtoList(List<Product> products) {
		
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		
		for (Product product : products) {
			productDtos.add(convertProductToProductDto(product));
		}
		
		return productDtos;
	}	
}
