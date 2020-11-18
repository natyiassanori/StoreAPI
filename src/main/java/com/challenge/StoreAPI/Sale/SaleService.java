package com.challenge.StoreAPI.Sale;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	public List<Sale> findByProductId(int productId) {
		return saleRepository.findByProductId(productId);
	}
}
