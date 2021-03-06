package com.challenge.StoreAPI.Sale;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.StoreAPI.Product.ProductService;
import com.challenge.StoreAPI.Product.Models.Product;

@Service
@Transactional
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired 
	private ProductService productService;
	
	public List<Sale> findByProductId(int productId) {
		return saleRepository.findByProductId(productId);
	}
	
	public double calculateRatingAverageOverThePastTwelveMonthsByProductId(int productId) {
		
		Calendar twelveMonthsAgo = Calendar.getInstance();	
		
		twelveMonthsAgo.add(Calendar.MONTH, -12);
		twelveMonthsAgo.set(Calendar.HOUR_OF_DAY, 0);
		
		Date dateOfTwelveMOnthsAgo = twelveMonthsAgo.getTime();
				
		List<Sale> salesByProduct = findByProductId(productId);
				
		List<Sale> salesByProductOverThePastTwelveMonths = salesByProduct.stream().filter(sale -> sale.getSaleDate().after(dateOfTwelveMOnthsAgo) || sale.getSaleDate().equals(dateOfTwelveMOnthsAgo)).collect(Collectors.toList());
		
		if(salesByProductOverThePastTwelveMonths.size() == 0)
			return 0;
	
		double sumOfRating = 0;
		
		for (Sale sale : salesByProductOverThePastTwelveMonths) {
			sumOfRating += sale.getEvaluation();
		}
		
		return sumOfRating/salesByProductOverThePastTwelveMonths.size();			
	}	
	
	public double calculateSalesByProductExistingDays(int productId) {
		
		List<Sale> salesByProduct = findByProductId(productId);
		
		Product product = productService.getProductById(productId);
	
		long numberOfDaysTheProductExists = product.getDaysOfExistence();
		
		return salesByProduct.size()/numberOfDaysTheProductExists;	
		
	}
	
	public boolean existsSaleByProductId(int productId) {
		
		return saleRepository.existsByProductId(productId);
	}
	
}
