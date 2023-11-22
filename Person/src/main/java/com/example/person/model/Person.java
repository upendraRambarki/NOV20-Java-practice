package com.example.person.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Person {
	@Id
	public int personId;
	public String personName;
	public int personAge;
	public Address address1;
	public Address address2;

}
