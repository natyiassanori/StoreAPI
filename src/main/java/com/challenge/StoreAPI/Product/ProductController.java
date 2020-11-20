package com.challenge.StoreAPI.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.StoreAPI.Product.Models.Product;
import com.challenge.StoreAPI.Product.Models.ProductDto;
import com.challenge.StoreAPI.Product.Models.ProductRanking;
import com.challenge.StoreAPI.ProductCategory.ProductCategoryService;
import com.challenge.StoreAPI.Sale.SaleService;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private SaleService saleService;
	

	@GetMapping("/all")
	public List<ProductDto> listAllProducts() {
		
		return productService.listAll();
		
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
		
        try {
        	
        	ProductDto productDto = productService.getById(id);
        	
            return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
            
        } catch (NoSuchElementException e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            
        }
    }
	
	@GetMapping("/findByName/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable String name) {
		
        try {
        	
            List<ProductDto> productDtos = productService.getByName(name);
            
            return new ResponseEntity<List<ProductDto>>(productDtos, HttpStatus.OK);
            
        } catch (NoSuchElementException e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            
        }
    }
	
	@GetMapping("/findByCategory/{category}")
    public ResponseEntity<?> getProductByProductCategoryId(@PathVariable int category) {
		
        try {
        	
            List<ProductDto> productDtos = productService.getByProductCategoryId(category);
            
            return new ResponseEntity<List<ProductDto>>(productDtos, HttpStatus.OK);
            
        } catch (NoSuchElementException e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            
        }
    }
	
	@PostMapping("/create")
	public ResponseEntity<String> createNewProduct(@RequestBody ProductDto productdDto) {
		
		if(productCategoryService.existsProductCategory(productdDto.getProductCategoryId())) {
			
			productService.create(productdDto);
			
			return ResponseEntity.status(HttpStatus.OK).body("Product successfully created");
		} else {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Category does not exists");
		}
		
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDto productdDto, @PathVariable int id) {
		
		try {		
            if (productCategoryService.existsProductCategory(productdDto.getProductCategoryId())) {
    			
            	productService.update(productdDto, id);			
    			
                return ResponseEntity.status(HttpStatus.OK).body("Product successfully updated");
    		} else {
    			
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Category does not exists");
    		}
            
        } catch (NoSuchElementException e) {      
        	
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exist");
        	
        }
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		
		try {
			
			if(saleService.existsSaleByProductId(id))
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("It is not possible to delete a product that has an associated sale");
			else {
				productService.delete(id);
				
				return ResponseEntity.status(HttpStatus.OK).body("Product deleted");				
			}
			
		} catch (NoSuchElementException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exist");
			
		}
		
	}
	
	
	@GetMapping("/ranking")
    public ResponseEntity<?> getProductsOrderedByRanking(@RequestParam String name, @RequestParam String category) {
		
        try {        	
        	
            List<ProductDto> productDtos = productService.getByNameAndCategoryOrderByScoreDescending(name, category);
            
            ProductRanking productRanking = new ProductRanking(new Date(), name, productDtos);
            
            return new ResponseEntity<ProductRanking>(productRanking, HttpStatus.OK);
            
        } catch (NoSuchElementException e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            
        }
    }
}
