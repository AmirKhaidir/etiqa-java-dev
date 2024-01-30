package com.etiqa.custpro.product;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String bookTitle;
	private BigDecimal bookPrice;
	private Integer bookQuantity;
	
	
	/**
	 * 
	 */
	public Product() {
	}
	

	/**
	 * @param bookTitle
	 * @param bookPrice
	 * @param bookQuantity
	 */
	public Product(String bookTitle, BigDecimal bookPrice, Integer bookQuantity) {
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
		this.bookQuantity = bookQuantity;
	}


	/**
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}
	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	/**
	 * @return the bookPrice
	 */
	public BigDecimal getBookPrice() {
		return bookPrice;
	}
	/**
	 * @param bookPrice the bookPrice to set
	 */
	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}
	/**
	 * @return the bookQuantity
	 */
	public Integer getBookQuantity() {
		return bookQuantity;
	}
	/**
	 * @param bookQuantity the bookQuantity to set
	 */
	public void setBookQuantity(Integer bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
}
