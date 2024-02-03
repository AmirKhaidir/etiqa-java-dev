package com.etiqa.custpro.customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiqa.custpro.family.Family;
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
		
		if (request.getFamilies().size() > 0) {
			Collection<Family> families = new ArrayList<Family>();
			request.getFamilies().forEach (family -> {
				Family fam = modelMapper.map(family, Family.class);
				fam.setCustomer(customer);
				families.add(fam);
			});
			customer.setFamilies(families);
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
	public void updateCustomer(UpdateCustomerRequest request) {
		// TODO Auto-generated method stub
		System.out.println("Update customer: " + request);
		
		Customer cust = customerRepository.findById(Long.parseLong(request.getId()))
				.orElseThrow(() -> new IllegalStateException("Customer does not exist"));
		
		Optional<Customer> isEmailExists = customerRepository.findCustomerByEmail(request.getEmail());
		
		if (isEmailExists.isPresent()) {
			throw new IllegalStateException("Email already registered");
		}
		
		cust.setFirstName(request.getFirstName());
		cust.setLastName(request.getLastName());
		cust.setEmail(request.getEmail());
	}
}
