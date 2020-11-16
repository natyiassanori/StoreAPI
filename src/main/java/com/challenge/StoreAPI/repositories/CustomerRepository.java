package com.challenge.StoreAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.challenge.StoreAPI.models.Customer;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public List<Customer> findByNameContaining(String name);
}
