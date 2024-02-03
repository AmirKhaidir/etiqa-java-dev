package com.etiqa.custpro.family;

import com.etiqa.custpro.enumeration.Relationship;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddFamilyRequest {
	@NotBlank(message = "Family member first name is required")
	private String firstName;
	@NotBlank(message = "Family member last name required")
	private String lastName;
	@NotBlank(message = "Age is required")
	@Positive(message = "Age need to be greater than 0")
	private Integer age;
	@NotBlank(message = "Relationship required")
	private Relationship relationship;
	
}
