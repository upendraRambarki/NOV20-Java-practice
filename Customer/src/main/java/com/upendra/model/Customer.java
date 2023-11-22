package com.upendra.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	int id;
	String firstName;
	String lastName;
	String street;
	String city;
	String state;
	String zip;
	String country;
	
	
}
