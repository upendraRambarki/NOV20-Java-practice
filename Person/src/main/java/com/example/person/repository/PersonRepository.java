package com.example.person.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.person.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

	public Person findByPersonId(int id);

	public Person findByPersonName(String name);

	List<Person> findByPersonAge(int age);

	List<Person> findByAddress1State(String state);

	List<Person> findByAddress2State(String state);

}
