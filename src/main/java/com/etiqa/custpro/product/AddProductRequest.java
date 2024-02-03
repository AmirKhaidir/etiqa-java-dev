package com.etiqa.custpro.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;


public class AddProductRequest {
	@NotBlank(message = "Book title is required")
	private String bookTitle;
	@Positive
	private BigDecimal bookPrice;
	@PositiveOrZero
	private Integer bookQuantity;

	/**
	 * 
	 */
	public AddProductRequest() {
	}

	/**
	 * @param bookTitle
	 * @param bookPrice
	 * @param bookQuantity
	 */
	public AddProductRequest(String bookTitle, BigDecimal bookPrice, Integer bookQuantity) {
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

	@Override
	public String toString() {
		return "AddProductRequest [" + (bookTitle != null ? "bookTitle=" + bookTitle + ", " : "")
				+ (bookPrice != null ? "bookPrice=" + bookPrice + ", " : "")
				+ (bookQuantity != null ? "bookQuantity=" + bookQuantity : "") + "]";
	}

}
