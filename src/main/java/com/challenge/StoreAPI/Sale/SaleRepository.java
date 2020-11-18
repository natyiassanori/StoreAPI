package com.challenge.StoreAPI.Sale;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer>{

	public List<Sale> findByProductId(int productId);
	
}