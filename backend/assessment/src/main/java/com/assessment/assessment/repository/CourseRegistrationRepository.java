package com.assessment.assessment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.assessment.model.Course;
import com.assessment.assessment.model.CourseRegistration;
import com.assessment.assessment.model.Student;



@Repository
public interface CourseRegistrationRepository extends CrudRepository<CourseRegistration, Integer>{
	public  List<CourseRegistration> findByStudent(Student student);
	public Integer deleteByCourseAndStudent(Course Course, Student student);
	

	
}
