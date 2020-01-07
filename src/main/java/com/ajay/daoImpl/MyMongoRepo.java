package com.ajay.daoImpl;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ajay.entity.Person;

@Repository
public interface MyMongoRepo extends MongoRepository<Person, Integer> {

	
}
