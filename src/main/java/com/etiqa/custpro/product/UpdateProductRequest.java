package com.etiqa.custpro.product;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateProductRequest {
	@NotNull(message = "Id is required")
	private Long id;
	private String bookTitle;
	private BigDecimal bookPrice;
	private Integer bookQuantity;

	/**
	 * 
	 */
	public UpdateProductRequest() {
	}

	/**
	 * @param id
	 * @param bookTitle
	 * @param bookPrice
	 * @param bookQuantity
	 */
	public UpdateProductRequest(@NotBlank Long id, String bookTitle, BigDecimal bookPrice, Integer bookQuantity) {
		this.id = id;
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
		this.bookQuantity = bookQuantity;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
		return "UpdateProductRequest [" + (id != null ? "id=" + id + ", " : "")
				+ (bookTitle != null ? "bookTitle=" + bookTitle + ", " : "")
				+ (bookPrice != null ? "bookPrice=" + bookPrice + ", " : "")
				+ (bookQuantity != null ? "bookQuantity=" + bookQuantity : "") + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookPrice, bookQuantity, bookTitle, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdateProductRequest other = (UpdateProductRequest) obj;
		return Objects.equals(bookPrice, other.bookPrice) && Objects.equals(bookQuantity, other.bookQuantity)
				&& Objects.equals(bookTitle, other.bookTitle) && Objects.equals(id, other.id);
	}
	
}
