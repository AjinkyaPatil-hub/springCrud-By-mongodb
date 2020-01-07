package com.ajay.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BookInfo")
public class Person {

	@Id
	private int id;
	private String name;
	private String city;
	private int pincode;
	public Person() {
		super();
	}
	public Person(int id, String name, String city, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.pincode = pincode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
}
