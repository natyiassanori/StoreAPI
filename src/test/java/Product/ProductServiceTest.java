package Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.challenge.StoreAPI.NewsPerCategory.NewsPerProductCategoryService;
import com.challenge.StoreAPI.Product.ProductMapper;
import com.challenge.StoreAPI.Product.ProductRepository;
import com.challenge.StoreAPI.Product.ProductService;
import com.challenge.StoreAPI.Product.Models.Product;
import com.challenge.StoreAPI.Product.Models.ProductDto;
import com.challenge.StoreAPI.ProductCategory.ProductCategory;
import com.challenge.StoreAPI.ProductCategory.ProductCategoryService;
import com.challenge.StoreAPI.Sale.SaleRepository;
import com.challenge.StoreAPI.Sale.SaleService;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@Mock
	SaleService saleService;
	
	@Mock
	NewsPerProductCategoryService newsPerProductCategoryService;
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	ProductCategoryService productCategoryService;

	@InjectMocks
	ProductService productService;
	
	@Test
	public void ProductScoreShouldBeFiveWhenProductRatingAvaregeOverThePastTwelveMonthsIsThreeAndSalesPerProductExistenceDaysIsTwoAndNewsPerProductCategoryIsTwo() {
		
		Product product = new Product();
		product.setProductCategoryId(1);
		
		Mockito.when(saleService.calculateRatingAverageOverThePastTwelveMonthsByProductId(product.getProductId())).thenReturn(3.0);
		
		Mockito.when(saleService.calculateSalesByProductExistingDays(product.getProductId())).thenReturn(2.0);
		
		Mockito.when(newsPerProductCategoryService.getNewsCountByProductCategoryId(product.getProductCategoryId())).thenReturn(2);
		
			
		double score = productService.calculateProductScore(product.getProductId(), product.getProductCategoryId());
		
		
		Assert.assertEquals(7.0, score, 0);		
	}	
	
	
	@Test
	public void ProductScoreShouldBeZeroWhenProductRatingAvaregeOverThePastTwelveMonthsIsZeroAndSalesPerProductExistenceDaysIsZeroAndNewsPerProductCategoryIsZero() {
		
		Product product = new Product();
		product.setProductCategoryId(1);
		
		Mockito.when(saleService.calculateRatingAverageOverThePastTwelveMonthsByProductId(product.getProductId())).thenReturn(0.0);
		
		Mockito.when(saleService.calculateSalesByProductExistingDays(product.getProductId())).thenReturn(0.0);
		
		Mockito.when(newsPerProductCategoryService.getNewsCountByProductCategoryId(product.getProductCategoryId())).thenReturn(0);
		
			
		double score = productService.calculateProductScore(product.getProductId(), product.getProductCategoryId());
		
		
		Assert.assertEquals(0.0, score, 0);		
	}
	
	@Test
	public void WhenUpdateScoreOfAListOfTwoProductsShouldCallProductRepositorySaveMethodOneTimesWithFirstProductAndOneTimeWithSecondProduct() {
		
		Product productOne = new Product();
		productOne.setProductCategoryId(1);
		
		Product productTwo = new Product();
		productOne.setProductCategoryId(2);
		
		List<Product> products = new ArrayList<Product>();
		
		products.add(productOne);
		products.add(productTwo);
		
		Mockito.when(productRepository.findAll()).thenReturn(products);
		
		Mockito.when(saleService.calculateRatingAverageOverThePastTwelveMonthsByProductId(productOne.getProductId())).thenReturn(0.0);
		Mockito.when(saleService.calculateRatingAverageOverThePastTwelveMonthsByProductId(productTwo.getProductId())).thenReturn(0.0);
		
		Mockito.when(saleService.calculateSalesByProductExistingDays(productOne.getProductId())).thenReturn(0.0);
		Mockito.when(saleService.calculateSalesByProductExistingDays(productTwo.getProductId())).thenReturn(0.0);
		
		Mockito.when(newsPerProductCategoryService.getNewsCountByProductCategoryId(productOne.getProductCategoryId())).thenReturn(0);
		Mockito.when(newsPerProductCategoryService.getNewsCountByProductCategoryId(productTwo.getProductCategoryId())).thenReturn(0);
		
		
		productService.updateProductScores();
		
		Mockito.verify(productRepository, Mockito.times(1)).save(productOne);
		Mockito.verify(productRepository, Mockito.times(1)).save(productTwo);
	}
	
	@Test
	public void ListOfProductDtosShouldBeOrderedInDescendingOrderByScoreValueWhenGetProductsByNameAndCategoryOrderByScoreDescendingIsCalled(){
			
		String searchedCategory = "category";
		String searchedProductName = "product";
		
		Date productOneCreationDate = new Date();
		Product productOne = new Product("product One", "product one description", productOneCreationDate, 5, 1);
		
		Date productTwoCreationDate = new Date();
		Product productTwo = new Product("product Two", "product two description", productTwoCreationDate, 8, 1);
		
		Date productThreeCreationDate = new Date();
		Product productThree = new Product("product Three", "product three description", productThreeCreationDate, 12, 1);

		List<Product> products = new ArrayList<Product>();
		products.add(productOne);
		products.add(productTwo);
		products.add(productThree);
		
		ProductCategory productCategory = new ProductCategory("category");
		
		Mockito.when(productCategoryService.getByProductCategoryByDescription(searchedCategory)).thenReturn(productCategory);
		Mockito.when(productRepository.findByNameContainingAndProductCategoryId(searchedProductName, productCategory.getProductCategoryId())).thenReturn(products);
		
		
		List<ProductDto> productDtos = productService.getByNameAndCategoryOrderByScoreDescending(searchedProductName, searchedCategory);
		
		
		Assert.assertEquals(3, productDtos.size());
		
		Assert.assertEquals(productThree.getProductId(), productDtos.get(0).getProductId());
		Assert.assertEquals(productThree.getScore(), productDtos.get(0).getScore(), 0);
		
		Assert.assertEquals(productTwo.getProductId(), productDtos.get(1).getProductId());
		Assert.assertEquals(productTwo.getScore(), productDtos.get(1).getScore(), 0);
		
		Assert.assertEquals(productOne.getProductId(), productDtos.get(2).getProductId());
		Assert.assertEquals(productOne.getScore(), productDtos.get(2).getScore(), 0);
	}
	
	@Test
	public void ProductRepositoryFindByNameContainingMethodShouldBeCalledWhenSearchedCategoryIsAnEmptyString(){
			
		String searchedCategory = "";
		String searchedProductName = "product";
		
		Date productOneCreationDate = new Date();
		Product productOne = new Product("product One", "product one description", productOneCreationDate, 5, 1);
		
		Date productTwoCreationDate = new Date();
		Product productTwo = new Product("product Two", "product two description", productTwoCreationDate, 8, 1);
		
		Date productThreeCreationDate = new Date();
		Product productThree = new Product("product Three", "product three description", productThreeCreationDate, 12, 1);

		List<Product> products = new ArrayList<Product>();
		products.add(productOne);
		products.add(productTwo);
		products.add(productThree);
		
		ProductCategory productCategory = new ProductCategory("category");
		
		Mockito.when(productRepository.findByNameContaining(searchedProductName)).thenReturn(products);
		
		
		productService.getByNameAndCategoryOrderByScoreDescending(searchedProductName, searchedCategory);
		
		
		Mockito.verify(productRepository, Mockito.times(1)).findByNameContaining(searchedProductName);
	}

}
