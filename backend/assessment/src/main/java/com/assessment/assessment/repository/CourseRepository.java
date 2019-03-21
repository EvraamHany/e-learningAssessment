package com.assessment.assessment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.assessment.model.Course;



@Repository
public interface CourseRepository extends CrudRepository<Course, Integer>{
	public Course findById(Integer id);

	
}
