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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.daoImpl.MyMongoRepo;
import com.ajay.entity.User;

@RestController
public class PersonController {

	@Autowired
	MyMongoRepo dao;
	
	@GetMapping(value="/")
	public List<User> getAllPersons(){
		return dao.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<User> getPerson(@PathVariable int id) {
		return dao.findById(id);
	}
	
	@PostMapping("/save")
	public User savePerson(@RequestBody User person) {
	 	return dao.save(person);
	}
	
	@PutMapping(value="/update")
	public String update(@RequestBody User person){
		Optional<User> findById = dao.findById(person.getId());
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
		Optional<User> findById = dao.findById(id);
		if(findById.isPresent()) {
			dao.deleteById(id);
			return "person deleted..";
		}else {
			return "Invalid person cannot delete...";
		}
	}

	@RequestMapping(value="/city/{city}" ,method = RequestMethod.GET)	
	public List<User> findByCity(@PathVariable String city){
		return dao.findByCity(city);
	}
	
	@GetMapping(value="/name/{name}")
	public List<User> getByUserName(@PathVariable String name){
		return dao.findByName(name);
	}
}
