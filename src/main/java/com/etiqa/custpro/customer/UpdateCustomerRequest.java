package com.etiqa.custpro.customer;

import java.util.List;

import com.etiqa.custpro.family.AddFamilyRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.Data;

@Data
public class UpdateCustomerRequest {
	@NotBlank(message = "Id is required!")
	private String id;
	@NotBlank(message = "First name is required.")
	private String firstName;
	@NotBlank(message = "Last name is required.")
	private String lastName;
	@NotBlank(message = "Email is required.")
	@Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
	private String email;
}
