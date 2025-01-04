package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Student;

public interface StudentService {

	
	public List<Student> getStudents();
	
	public Student create(Student student);
	
	public Student getStudentById(long id );
	
	public Student update(Student student, long id);
	
	void delete( long id);

	
}
