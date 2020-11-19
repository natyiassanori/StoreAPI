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
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	public List<Product> listAllProducts() {
		
		return productService.listAll();
		
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
		
        try {
        	
        	Product product = productService.get(id);
        	
            return new ResponseEntity<Product>(product, HttpStatus.OK);
            
        } catch (NoSuchElementException e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            
        }
    }
	
	@GetMapping("/name/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable String name) {
		
        try {
        	
            List<Product> products = productService.getByName(name);
            
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
            
        } catch (NoSuchElementException e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            
        }
    }
	
	@GetMapping("/category/{category}")
    public ResponseEntity<?> getProductByProductCategoryId(@PathVariable int category) {
		
        try {
        	
            List<Product> products = productService.getByProductCategoryId(category);
            
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
            
        } catch (NoSuchElementException e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            
        }
    }
	
	@PostMapping("/")
	public ResponseEntity<String> createNewProduct(@RequestBody Product product) {
		
		product.setCreationDate(new Date());
		
		productService.save(product);
		
		return ResponseEntity.status(HttpStatus.OK).body("Product successfully created");
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateProduct(@RequestBody Product product, @PathVariable int id) {
		
		try {			
			
			Product existProduct = productService.get(id);
			
			existProduct.setName(product.getName());
			existProduct.setDescription(product.getDescription());
			existProduct.setCreationDate(product.getCreationDate());
			existProduct.setScore(product.getScore());
			existProduct.setProductCategoryoId(product.getProductCategoryId());
			
			productService.save(existProduct);			
			
            return ResponseEntity.status(HttpStatus.OK).body("Product successfully updated");
            
        } catch (NoSuchElementException e) {      
        	
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exist");
        	
        }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		
		productService.delete(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
		
	}
	
	
	@GetMapping("/ranking/{name}")
    public ResponseEntity<?> getProductsOrderedByRanking(@PathVariable String name) {
		
        try {
        	
            List<Product> products = productService.getByName(name);
            
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
            
        } catch (NoSuchElementException e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            
        }
    }
}
