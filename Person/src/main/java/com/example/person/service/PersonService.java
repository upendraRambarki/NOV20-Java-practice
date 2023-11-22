package com.example.person.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepo;

	public List<Person> getAll() {
		return personRepo.findAll();

	}

	public Person getByPersonId(int id) {
		return personRepo.findByPersonId(id);
	}

	public Person getByPersonName(String name) {
		return personRepo.findByPersonName(name);
	}

	public List<Person> getByPersonAge(int age) {
		return personRepo.findByPersonAge(age);

	}

	public List<Person> getByPersonState(String state) {
		return personRepo.findByAddress1State(state);
	}

	public List<Person> getByPersonState2(String state) {
		return personRepo.findByAddress2State(state);
	}

	public List<Person> getPersonsByState(String states) {
		List<Person> list = new ArrayList<>();
		List<Person> address1 = personRepo.findByAddress1State(states);
		List<Person> address2 = personRepo.findByAddress2State(states);
		if (address1 != null) {
			for (Person person : address1) {
				list.add(person);

			}
		}
		if (address2 != null) {
			for (Person person : address2) {
				Stream<Person> person2 = list.stream().filter(p -> p.getPersonId() == person.getPersonId());
				if (person2 == null) {
					list.add(person);

				}

			}
		}
		return list;

	}

	public Person addPerson(Person person) {
		return personRepo.save(person);

	}

	public Person updatePerson(Person person) {

		Person person2 = personRepo.findByPersonId(person.getPersonId());
		person2.setPersonName(person.getPersonName());
		person2.setPersonAge(person.getPersonAge());
		person2.setAddress1(person.getAddress1());
		person2.setAddress2(person.getAddress2());

		return personRepo.save(person2);

	}

	public String deletePerson(int id) {
		Person person = personRepo.findByPersonId(id);
		personRepo.delete(person);
		return "deleted succesfully";

	}

}
