package com.etiqa.custpro.family;

import com.etiqa.custpro.customer.Customer;
import com.etiqa.custpro.enumeration.Relationship;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Family {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private Relationship relationship;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="customer_id", nullable = false)
	private Customer customer;
}
