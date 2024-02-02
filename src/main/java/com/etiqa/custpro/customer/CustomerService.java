package com.etiqa.custpro.customer;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiqa.custpro.product.Product;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	public void addNewCustomer(AddCustomerRequest request) {
		log.info("Add new customer: " + request);
		Customer customer = modelMapper.map(request, Customer.class);
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
