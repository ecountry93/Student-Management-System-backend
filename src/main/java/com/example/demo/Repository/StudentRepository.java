package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

//@Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search,update and delete operation on objects.
@Repository
//Spring Data JPA  - the most compelling feature is the ability to create repository implementations automatically, at runtime, 
//from a repository interface 
public interface StudentRepository extends JpaRepository<Student,Long>{

}
