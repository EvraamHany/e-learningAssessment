package com.assessment.assessment.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.assessment.model.Course;
import com.assessment.assessment.model.CourseRegistration;
import com.assessment.assessment.model.Student;
import com.assessment.assessment.repository.CourseRegistrationRepository;
import com.assessment.assessment.repository.CourseRepository;
import com.assessment.assessment.repository.StudentRepository;

@Service
public class CourseRegistrationService {

	@Autowired
	CourseRegistrationRepository courseRegistrationRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;

	public List<CourseRegistration> getInRollCourses(Integer userId) {
		Student student = studentRepository.findById(userId);
		List<CourseRegistration> registedCourses = courseRegistrationRepository.findByStudent(student);
		return registedCourses;

	}

	@Transactional
	public Integer removeRegisteredCourse(Integer userId, Integer courseId) {
		Integer isDeleted = 0;
		Student student = studentRepository.findById(userId);
		Course course = courseRepository.findById(courseId);
		isDeleted = courseRegistrationRepository.deleteByCourseAndStudent(course, student);
		return isDeleted;

	}

	public CourseRegistration save(Integer userId, Integer courseId) {
		CourseRegistration courseRegistration = new CourseRegistration();

		Student student = studentRepository.findById(userId);
		Course course = courseRepository.findById(courseId);

		courseRegistration.setCourse(course);
		courseRegistration.setStudent(student);

		return courseRegistrationRepository.save(courseRegistration);

	}

}
