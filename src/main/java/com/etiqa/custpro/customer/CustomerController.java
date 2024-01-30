package com.etiqa.custpro.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
