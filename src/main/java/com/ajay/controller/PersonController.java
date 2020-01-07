package com.ajay.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.daoImpl.MyMongoRepo;
import com.ajay.entity.Person;

@RestController
public class PersonController {

	@Autowired
	MyMongoRepo dao;
	
	@GetMapping(value="/")
	public List<Person> getAllPersons(){
		return dao.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Person> getPerson(@PathVariable int id) {
		return dao.findById(id);
	}
	
	@PostMapping("/save")
	public Person savePerson(@RequestBody Person person) {
	 	return dao.save(person);
	}
	
	@PutMapping(value="/update")
	public String update(@RequestBody Person person){
		Optional<Person> findById = dao.findById(person.getId());
		if(findById.isPresent()) {
			dao.save(person);
			return "perosn updted..";
		}
		else {
			return "Invalid preson...";
		}
	}
	
	@DeleteMapping(value="/{id}")
	public String deleteById(@PathVariable int id) {
		Optional<Person> findById = dao.findById(id);
		if(findById.isPresent()) {
			dao.deleteById(id);
			return "person deleted..";
		}else {
			return "Invalid person cannot delete...";
		}
	}
}
