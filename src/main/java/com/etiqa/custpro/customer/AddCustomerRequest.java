package com.etiqa.custpro.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class AddCustomerRequest {
	private String firstName;
	private String lastName;
	@Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
	private String email;
}
