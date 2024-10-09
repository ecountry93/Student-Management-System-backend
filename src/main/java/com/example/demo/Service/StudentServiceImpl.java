package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

// @Service annotation is used with classes
//that provide some business functionalities or business logic
@Service
public class StudentServiceImpl {
	
	//dependency injection
	public StudentRepository repo;
	
	
	public StudentServiceImpl(StudentRepository repo) {
		
		this.repo = repo;
	}

	
	public List<Student> getStudents() {
		// fetches all the files from the database
		return repo.findAll();
	}
	//create operation
	public Student create(Student student) {
		// Saves all the files into database
    	return repo.save(student);
    }
	
	//read operation
	public  Student getStudentById(long id ) {
		Student student = repo.findById(id).orElseThrow(null);
			return student;
	}
	//update operation
	public Student update(Student student, long id) {
		
		//Updates files in the database
		Student existingStudent = repo.findById(id).orElseThrow(null);
		
		existingStudent.setFirstName(student.getName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
	    repo.save(existingStudent);
	    return existingStudent;
	}
    
  
	//delete operation
	public void delete( long id) {
		//Deletes files from the database
		
		repo.deleteById(id);
	}






	

}
