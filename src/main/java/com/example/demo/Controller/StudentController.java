package com.example.demo.Controller;





import java.util.List;

//Imported packages modules
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import com.example.demo.Service.StudentServiceImpl;


@CrossOrigin("http://localhost:3000")
@RestController



public class StudentController {
		
	// dependency injection
	public StudentService service;
	
	
	
	public StudentController(StudentService service) {
		this.service = service;
	}

	
	
	@GetMapping("/")
	
	public List<Student> getStudents(){
		//returns a list of student objects
		return service.getStudents();	
	}
	
	
	//Annotation for mapping HTTP POST requests onto specific handler methods
	 @PostMapping("/")
	// save operation
	  public ResponseEntity<Student> create(@RequestBody Student student) {
		return  new ResponseEntity<Student>(service.create(student), HttpStatus.CREATED);
		  
	  }
	
	//Annotation for mapping HTTP GET requests onto specific handler methods
	@GetMapping("/{id}")
	// read operation
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long id ) {
		return ( new ResponseEntity<Student>(service.getStudentById(id), HttpStatus.OK));
	}
	
	 
	//Annotation for mapping HTTP PUT requests onto specific handler methods
  @PutMapping("/{id}")
//update operation
  public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable("id") long id ){
	return new ResponseEntity<Student> (service.update(student, id), HttpStatus.OK);
	}
	   
  
  
//Annotation for mapping HTTP DELETE requests onto specific handler methods
	@DeleteMapping("/{id}")
	// delete operation
    public ResponseEntity<String> delete(@PathVariable ("id") long id) {
	
		service.delete(id);
		return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.OK);
	}
	
	  
	

}
