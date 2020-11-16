package com.challenge.StoreAPI.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.StoreAPI.models.Customer;
import com.challenge.StoreAPI.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	public List<Customer> listAll() {
		return customerRepository.findAll();
	}
	
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
	
	public Customer get(int id) {
		return customerRepository.findById(id).get();
	}
	
	public List<Customer> getByName(String name) {
		return customerRepository.findByNameContaining(name);
	}
	
	public void delete(int id) {
		customerRepository.deleteById(id);
	}
}
