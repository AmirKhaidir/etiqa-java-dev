package com.etiqa.custpro.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@PostMapping
	public void addNewCustomer(@RequestBody Customer customer) {
		customerService.addNewCustomer(customer);
	}
	
	@DeleteMapping(path = "{customerId}")
	public void DeleteStudent(@PathVariable Long customerId) {
		customerService.deleteCustomerById(customerId);
	}
	
	@PutMapping
	public void updateStudent(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}
}
