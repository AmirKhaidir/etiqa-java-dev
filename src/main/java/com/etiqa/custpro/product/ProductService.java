package com.etiqa.custpro.product;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public void addNewProduct(AddProductRequest request) {
		System.out.println("Add new product " + request);
		Product product = modelMapper.map(request, Product.class);
		Optional<Product> productExist = productRepository.findByBookTitle(product.getBookTitle());
		
		if (productExist.isPresent()) {
			throw new IllegalStateException("Product already exist!");
		}
		
		productRepository.save(product);
	}
	
	@Transactional
	public void updateProduct(@Valid UpdateProductRequest request) {
		System.out.println("updateProduct: " + request);
		
		Product product = productRepository.findById(request.getId())
				.orElseThrow(() -> new IllegalStateException("Product not exist!"));
		
		if (request.getBookTitle() != null || !request.getBookTitle().equals("")) {
			Optional<Product> prodExist = productRepository.findByBookTitle(request.getBookTitle());
			
			if (prodExist.isPresent()) {
				throw new IllegalStateException("Product already exist");
			}
			
		}

		product.setBookTitle(request.getBookTitle());
		product.setBookQuantity(request.getBookQuantity());
		product.setBookPrice(request.getBookPrice());

	}
	
	public void deleteProductById(Long productId) {
		System.out.println("delete product: " + productId);
		
		Boolean isProdExist = productRepository.existsById(productId);
		
		if (!isProdExist) {
			throw new IllegalStateException("Product not exist!");
		}

		productRepository.deleteById(productId);
	}
}
