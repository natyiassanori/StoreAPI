import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.challenge.StoreAPI.Product.Models.Product;

@RunWith(MockitoJUnitRunner.class)
public class ProductTest {

	
	@Test
	public void NumberOfDaysTheProductExistsShouldBeOneIfTodayIsTheProductCreationDay() {
		
		Date today = new Date();
		
		Product product = new Product();
		product.setProductId(1);
		product.setName("SomeProduct");
		product.setCreationDate(today);
				
		
		long numberOfDaysTheProductExists = product.getDaysOfExistence();		
		
		//the number of days is one because I consider the day the product was created		
		Assert.assertEquals(1, numberOfDaysTheProductExists, 0);
		
	}	
	
	@Test
	public void NumberOfDaysTheProductExistsShouldBeTwoIfTheProductCreationDayIfYesterday() {
				
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DAY_OF_YEAR, -1);
		
		Date dateOfYesterday = yesterday.getTime();
		
		Product product = new Product();
		product.setProductId(1);
		product.setName("SomeProduct");
		product.setCreationDate(dateOfYesterday);
				
		
		long numberOfDaysTheProductExists = product.getDaysOfExistence();		
		
		
		//the number of days is two because I also consider the day the product was created		
		Assert.assertEquals(2, numberOfDaysTheProductExists, 0);
		
	}
	
	@Test
	public void NumberOfDaysTheProductExistsShouldBeEightIfTheProductCreationDayIfSevenDaysAgo() {
				
		Calendar sevenDaysAgo = Calendar.getInstance();
		sevenDaysAgo.add(Calendar.DAY_OF_YEAR, -7);
		
		Date dateOfSevenDaysAgo = sevenDaysAgo.getTime();
		
		Product product = new Product();
		product.setProductId(1);
		product.setName("SomeProduct");
		product.setCreationDate(dateOfSevenDaysAgo);
				
		
		long numberOfDaysTheProductExists = product.getDaysOfExistence();	
		
		
		//the number of days is eight because I also consider the day the product was created		
		Assert.assertEquals(8, numberOfDaysTheProductExists, 0);
		
	}
	
}
