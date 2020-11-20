package com.challenge.StoreAPI;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.challenge.StoreAPI.NewsPerCategory.NewsPerProductCategoryService;

@Configuration
@EnableScheduling
public class ScheduledConfiguration {

	@Autowired
	NewsPerProductCategoryService newsPerProductCategoryService;
	
	//task runs every 8 hours interval
	//@Scheduled(fixedRate = 8*60*60*1000)
	public void executeUpdateNewsByProductCategory() {
		
		System.out.println("News count per product category updated at " + new Date());
		
		newsPerProductCategoryService.updateNewsByProductCategory();
	}
}
