package com.example.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.person.model.Person;
import com.example.person.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	PersonService personService;

	@GetMapping("/getAll")
	public List<Person> getPersons() {
		return personService.getAll();

	}

	@GetMapping("getPersonId/{id}")
	public Person getPersonId(@PathVariable("id") int id) {
		return personService.getByPersonId(id);
	}

	@GetMapping("getPersonName/{name}")
	public Person getPersonName(@PathVariable("name") String name) {
		return personService.getByPersonName(name);

	}

	@GetMapping("getPersonsAge/{age}")
	public List<Person> getPersonsAge(@PathVariable("age") int age) {
		return personService.getByPersonAge(age);

	}

	@GetMapping("getPersonState/{state}")
	public List<Person> getPersonState(@PathVariable("state") String state) {
		return personService.getByPersonState(state);
	}

	@GetMapping("getPersonState2/{state}")
	public List<Person> getPersonState2(@PathVariable("state") String state) {
		return personService.getByPersonState2(state);
	}

	@GetMapping("getPersonByState/{states}")
	public List<Person> getPersonsByState(@PathVariable("states") String states) {
		return personService.getPersonsByState(states);
	}

	@PostMapping("addPerson")
	public Person addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}

	@PutMapping("updatePerson")
	public Person updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);

	}

	@DeleteMapping("removePerson")
	public String removePerson(int id) {
		return personService.deletePerson(id);

	}

}
