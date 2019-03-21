package com.assessment.assessment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.assessment.model.Course;
import com.assessment.assessment.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	public List<Course> findallAvailableCources() {

		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);

		return courses;
	}

	public Course save(Course course) {

		Course addedCourse = courseRepository.save(course);
		return addedCourse;

	}

}
