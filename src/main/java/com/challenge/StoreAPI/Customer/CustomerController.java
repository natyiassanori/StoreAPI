package com.challenge.StoreAPI.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/all")
	public List<Customer> listAllCustomers() {
		
		return customerService.listAll();
		
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
		
        try {
        	
            Customer customer = customerService.get(id);
            
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
            
        } catch (NoSuchElementException e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
            
        }
    }
	
	@GetMapping("/name/{name}")
    public ResponseEntity<?> getCustomerByName(@PathVariable String name) {
        try {
        	
            List<Customer> customers = customerService.getByName(name);
            
            return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
            
        } catch (NoSuchElementException e) {
        	
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
            
        }
    }
	
	@PostMapping("/")
	public ResponseEntity<String> createNewCustomer(@RequestBody Customer customer) {
		
		customerService.save(customer);
		
		return ResponseEntity.status(HttpStatus.OK).body("Customer successfully created");
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
		
		try {			
			
			Customer existCustomer = customerService.get(id);
			
			existCustomer.setName(customer.getName());
			
			customerService.save(existCustomer);			
			
            return ResponseEntity.status(HttpStatus.OK).body("Customer successfully updated");
            
        } catch (NoSuchElementException e) {     
        	
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer does not exist");
        	
        }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
		
		customerService.delete(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Customer deleted");
		
	}
}
