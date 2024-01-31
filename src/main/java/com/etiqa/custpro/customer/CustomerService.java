package com.etiqa.custpro.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	public void addNewCustomer(Customer customer) {
		System.out.println("Add new customer: " + customer);
		Optional<Customer> custExist = customerRepository.findCustomerByEmail(customer.getEmail());
		
		if (custExist.isPresent()) {
			throw new IllegalStateException("Email already registered");
		}
		customerRepository.save(customer);
	}

	public void deleteCustomerById(Long id) {
		System.out.println("delete customer by id - ["+ id +"]");
		boolean isExists = customerRepository.existsById(id);
		
		if (!isExists) {
			throw new IllegalStateException("Customer does not exists");
		}
		customerRepository.deleteById(id);
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Update customer: " + customer);
		
		Customer cust = customerRepository.findById(customer.getId())
				.orElseThrow(() -> new IllegalStateException("Customer does not exist"));
		
		Optional<Customer> isEmailExists = customerRepository.findCustomerByEmail(customer.getEmail());
		
		if (isEmailExists.isPresent()) {
			throw new IllegalStateException("Email already registered");
		}
		
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setEmail(customer.getEmail());
	}
}
