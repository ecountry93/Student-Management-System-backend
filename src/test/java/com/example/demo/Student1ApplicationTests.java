package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.StudentServiceImpl;


@SpringBootTest
@AutoConfigureMockMvc
class Student1ApplicationTests {

	@Mock
	private StudentRepository repo;
	
	@InjectMocks
	private StudentServiceImpl service;
	
	private Student student;
	
	private List<Student> students;
	
	@BeforeEach
	void setUp() {
		 student = new Student(1L,"Alex","Popescu","alex_popescu@yahoo.com");
		 students = List.of(new Student(1L,"Alex","Popescu","alex_popescu@yahoo.com"),
				 new Student(2L,"Alin","Popa","alin_popa@yahoo.com"));
	}
	
	@Test
	public void testGetStudentById() {
	
		when(repo.findById(anyLong())).thenReturn(Optional.of(student));
		
		Student found = service.getStudentById(1L);
		
		assertNotNull(found);
		assertEquals("Alex", found.getFirstName());
		assertEquals("Popescu", found.getLastName());
		assertEquals("alex_popescu@yahoo.com", found.getEmail());
		verify(repo, times(1)).findById(1L);
	}
	@Test
	public void testCreateStudent() {
		
		when(repo.save(any(Student.class))).thenReturn(student);
		
		Student created = service.create(student);
		
		assertNotNull(created);
		assertEquals("Alex", created.getFirstName());
		assertEquals("Popescu", created.getLastName());
		assertEquals("alex_popescu@yahoo.com", created.getEmail());
		verify(repo, times(1)).save(student);
	}
	
	
	@Test
	public void testUpdateStudent() {
		
		when(repo.findById(anyLong())).thenReturn(Optional.of(student));
		
		when(repo.save(any(Student.class))).thenReturn(student);
		
		 student.setFirstName("Dan");
		 student.setLastName("Ionescu");
		 student.setEmail("dan_ionescu@yahoo.com");
		 
		 Student updated = service.update(student, 1L);
		
		assertNotNull(updated);
		assertEquals("Dan", updated.getFirstName());
		assertEquals("Ionescu", updated.getLastName());
		assertEquals("dan_ionescu@yahoo.com", updated.getEmail());
		verify(repo, times(1)).save(student);
	}
	
	@Test
	public void testDeleteStudent() {
		
		when(repo.findById(anyLong())).thenReturn(Optional.of(student));
		
		doNothing().when(repo).deleteById(anyLong());
		service.delete(1L);
		verify(repo, times(1)).deleteById(1L);
	}
	
	@Test
	public void testGetAllStudents() {
		
		when(repo.findAll()).thenReturn(students);
		
		List<Student> foundStudents = service.getStudents();
		
		assertNotNull(foundStudents);
		assertEquals(2,foundStudents.size());
		verify(repo, times(1)).findAll();
		
		
		
	}
}
