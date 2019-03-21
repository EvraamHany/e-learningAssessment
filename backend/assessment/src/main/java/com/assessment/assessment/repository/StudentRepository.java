package com.assessment.assessment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.assessment.model.Student;



@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{
	public Student findByUsernameAndPassword(String username, String Password);
	public Student findById(Integer id);
	
}
