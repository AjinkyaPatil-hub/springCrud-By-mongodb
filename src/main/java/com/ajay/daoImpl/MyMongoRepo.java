package com.ajay.daoImpl;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ajay.entity.User;

@Repository
public interface MyMongoRepo extends MongoRepository<User, Integer> {
	
	//for fetching user by usrename
	public List<User> findByName(String name);
	
	//for fetching city that is mapped in the address table
	@Query("{'Address.city':?0}")
	public List<User> findByCity(String city);
	
}
