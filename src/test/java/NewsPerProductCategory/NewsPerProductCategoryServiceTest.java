package NewsPerProductCategory;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.challenge.StoreAPI.NewsPerCategory.NewsPerCategoryRepository;
import com.challenge.StoreAPI.NewsPerCategory.NewsPerProductCategory;
import com.challenge.StoreAPI.NewsPerCategory.NewsPerProductCategoryService;
import com.challenge.StoreAPI.Product.ProductService;
import com.challenge.StoreAPI.ProductCategory.ProductCategory;
import com.challenge.StoreAPI.ProductCategory.ProductCategoryService;

@RunWith(MockitoJUnitRunner.class)
public class NewsPerProductCategoryServiceTest {

	@Mock
	NewsPerCategoryRepository newsPerCategoryRepository;
	
	@Mock
	ProductCategoryService productCategoryService;
	
	@Mock
	ProductService productService;
	
	@InjectMocks
	NewsPerProductCategoryService newsPerProductCategoryService;
	
	
	@Test
	public void NewsPerCategorySaveMethodShouldBeCalledThreeTimesForAListOfThreeProductCategories() {
		
		List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
		
		ProductCategory categoryOne = new ProductCategory("category 1");
		categoryOne.setProductCategoryId(1);
		
		ProductCategory categoryTwo = new ProductCategory("category 2");
		categoryTwo.setProductCategoryId(2);
		
		ProductCategory categoryThree = new ProductCategory("category 3");
		categoryThree.setProductCategoryId(3);
		
		productCategories.add(categoryOne);
		productCategories.add(categoryTwo);
		productCategories.add(categoryThree);
		
		NewsPerProductCategory newsOne = new NewsPerProductCategory(productCategories.get(0).getProductCategoryId(), 0);
		NewsPerProductCategory newsTwo = new NewsPerProductCategory(productCategories.get(1).getProductCategoryId(), 10);
		NewsPerProductCategory newsThree = new NewsPerProductCategory(productCategories.get(2).getProductCategoryId(), 5);
		
		Mockito.when(productCategoryService.getAll()).thenReturn(productCategories);
		
		Mockito.when(newsPerCategoryRepository.existsByProductCategoryId(productCategories.get(0).getProductCategoryId())).thenReturn(true);
		Mockito.when(newsPerCategoryRepository.existsByProductCategoryId(productCategories.get(1).getProductCategoryId())).thenReturn(true);
		Mockito.when(newsPerCategoryRepository.existsByProductCategoryId(productCategories.get(2).getProductCategoryId())).thenReturn(true);
		
		Mockito.when(newsPerCategoryRepository.findByProductCategoryId(productCategories.get(0).getProductCategoryId())).thenReturn(newsOne);
		Mockito.when(newsPerCategoryRepository.findByProductCategoryId(productCategories.get(1).getProductCategoryId())).thenReturn(newsTwo);
		Mockito.when(newsPerCategoryRepository.findByProductCategoryId(productCategories.get(2).getProductCategoryId())).thenReturn(newsThree);
		
		
		newsPerProductCategoryService.updateNewsByProductCategory();		
		
		
		Mockito.verify(newsPerCategoryRepository, Mockito.times(1)).save(newsOne);
		Mockito.verify(newsPerCategoryRepository, Mockito.times(1)).save(newsTwo);
		Mockito.verify(newsPerCategoryRepository, Mockito.times(1)).save(newsThree);
	}
	
}
