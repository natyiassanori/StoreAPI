
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.challenge.StoreAPI.Product.ProductService;
import com.challenge.StoreAPI.Product.Models.Product;
import com.challenge.StoreAPI.Sale.Sale;
import com.challenge.StoreAPI.Sale.SaleRepository;
import com.challenge.StoreAPI.Sale.SaleService;

@RunWith(MockitoJUnitRunner.class)
public class SaleServiceTest {

	@Mock
	SaleRepository saleRepository;
	
	@Mock
	ProductService productService;

	@InjectMocks
	SaleService saleService;
	
	@Test
	public void RatingAverageShouldOnlyConsiderSalesFromTheLastTwelveMonthsAgo() {
		
		Date today = new Date();
		
		Calendar twelveMonthsAgo = Calendar.getInstance();			
		twelveMonthsAgo.add(Calendar.MONTH, -12);		
		Date dateOfTwelveMonthsAgo = twelveMonthsAgo.getTime();
		
		Calendar twelveMonthsAndOneDayAgo = Calendar.getInstance();			
		twelveMonthsAndOneDayAgo.add(Calendar.DAY_OF_MONTH, -1);	
		twelveMonthsAndOneDayAgo.add(Calendar.MONTH, -12);			
		Date dateOfTwelveMonthsAndOneDayAgo = twelveMonthsAndOneDayAgo.getTime();
		
		List<Sale> salesOfSomeProduct = new ArrayList<Sale>();
		
		salesOfSomeProduct.add(new Sale(1,  1, 1, 5.0, today));
		salesOfSomeProduct.add(new Sale(1,  1, 1, 4.0, dateOfTwelveMonthsAgo));
		salesOfSomeProduct.add(new Sale(1,  1, 1, 3.0, dateOfTwelveMonthsAndOneDayAgo));
		
		Mockito.when(saleRepository.findByProductId(1)).thenReturn(salesOfSomeProduct);
		
		
		
		double ratingAverageOfPastTwelveMonths = saleService.calculateRatingAverageOverThePastTwelveMonthsByProductId(1);
		
		
		
		Assert.assertEquals(4.5, ratingAverageOfPastTwelveMonths, 0);
		
	}
	
	@Test
	public void RatingAverageShouldReturnZeroWhenThereAreNoSalesOfTheProductInTheLastTwelveMonths() {
				
		List<Sale> salesOfSomeProduct = new ArrayList<Sale>();
		
		Mockito.when(saleService.findByProductId(1)).thenReturn(salesOfSomeProduct);
		
		
		
		double ratingAverageOfPastTwelveMonths = saleService.calculateRatingAverageOverThePastTwelveMonthsByProductId(1);
		
		
		
		Assert.assertEquals(0, ratingAverageOfPastTwelveMonths, 0);
		
	}
	
	@Test
	public void SalesByProductExistenceDaysShouldBeTwoIfSalesOfProductsIsFourAndProductExistenceDaysIsTwo() {
				
		Date today = new Date();
		
		Calendar yesterday = Calendar.getInstance();			
		yesterday.add(Calendar.DAY_OF_YEAR, -1);		
		Date dateOfYesterday = yesterday.getTime();
		
		List<Sale> salesOfSomeProduct = new ArrayList<Sale>();
		
		salesOfSomeProduct.add(new Sale(1,  1, 1, 5.0, today));
		salesOfSomeProduct.add(new Sale(1,  1, 1, 4.0, today));
		salesOfSomeProduct.add(new Sale(1,  1, 1, 3.0, today));
		salesOfSomeProduct.add(new Sale(1,  1, 1, 3.0, today));
		
		Product product = new Product();
		product.setName("Some Product");
		product.setCreationDate(dateOfYesterday);
		
		Mockito.when(saleService.findByProductId(1)).thenReturn(salesOfSomeProduct);
		Mockito.when(productService.getProductById(1)).thenReturn(product);
				
		
		double salesByProductExistenceDays = saleService.calculateSalesByProductExistingDays(1);		
		
		
		Assert.assertEquals(2, salesByProductExistenceDays, 0);
		
	}
	
	@Test
	public void SalesByProductExistenceDaysShouldBeZeroIfSalesOfProductsIsZeroAndProductExistenceDaysIsTwo() {
						
		Calendar yesterday = Calendar.getInstance();			
		yesterday.add(Calendar.DAY_OF_YEAR, -1);		
		Date dateOfYesterday = yesterday.getTime();
		
		List<Sale> salesOfSomeProduct = new ArrayList<Sale>();
		
		Product product = new Product();
		product.setName("Some Product");
		product.setCreationDate(dateOfYesterday);
		
		Mockito.when(saleService.findByProductId(1)).thenReturn(salesOfSomeProduct);
		Mockito.when(productService.getProductById(1)).thenReturn(product);
				
		
		double salesByProductExistenceDays = saleService.calculateSalesByProductExistingDays(1);		
		
		
		Assert.assertEquals(0, salesByProductExistenceDays, 0);
		
	}
}
