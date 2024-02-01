package com.etiqa.custpro.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@PostMapping
	public void addNewProduct(@Valid @RequestBody AddProductRequest request) {
		productService.addNewProduct(request);
	}
	
	@PutMapping
	public void updateProductPrice(@Valid @RequestBody UpdateProductRequest request) {
		productService.updateProduct(request);
	}
	
	@DeleteMapping(path = "{productId}")
	public void deleteProductById(@PathVariable Long productId) {
		productService.deleteProductById(productId);
	}
}
