package com.etiqa.custpro.product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE p.bookTitle = :bookTitle ")
	public Optional<Product> findByBookTitle(@Param("bookTitle") String bookTitle);

}
