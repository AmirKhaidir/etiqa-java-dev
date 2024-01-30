package com.etiqa.custpro.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
}
