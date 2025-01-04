package com.example.demo.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//Entity annotation defines that a class can be mapped to a table
@Entity
//@Table annotation defines name of the table
@Table(name = "student")
public class Student {
     
	//Spring Data JPA focuses on using JPA to store data in a relational database
	//JPA's ORM mapping converts object-oriented Java code to the back-end database
	
	//@Id annotation specifies the primary key of an entity
	@Id
	//@GeneratedValue - Provides for the specification of generation strategies for the values of primary keys. 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public long id;
	
	@Column(name = "firstName")
	public String firstName;
	@Column(name = "lastName")
	public String lastName;
	@Column(name= "email")
	public String email;

	
	
    public Student(){
    	
    }

//Constructor
	public Student(long id, String firstName, String lastName, String email) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}




//getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	} 
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
