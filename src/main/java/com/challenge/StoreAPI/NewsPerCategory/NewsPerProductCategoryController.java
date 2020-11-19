package com.challenge.StoreAPI.NewsPerCategory;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/news")
public class NewsPerProductCategoryController {
	
	@Autowired
	NewsPerProductCategoryService newsService;

	@GetMapping("/updateNewsCountByProductCategory")
    public ResponseEntity<?> updateNewsCountByProductCategory() {
		
        try {
        	String newsOfDay = newsService.updateNewsByProductCategory();
        	
        	return ResponseEntity.status(HttpStatus.OK).body(newsOfDay);
            
        } catch (NoSuchElementException e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            
        }
    }
}
