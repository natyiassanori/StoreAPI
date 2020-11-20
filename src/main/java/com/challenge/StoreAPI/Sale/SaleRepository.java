package com.challenge.StoreAPI.Sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer>{

	public List<Sale> findByProductId(int productId);
	
	public boolean existsByProductId(int productId);
	
}