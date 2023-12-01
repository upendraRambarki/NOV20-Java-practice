package com.upendra.mentor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
	
	private Integer addressId;
	
	private String addressLine1;

	private String addressLine2;

	private String area; 
	
	private String city;
	
	private String state;

	private String country;

	private int pinCode;
}
