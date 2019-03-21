package com.assessment.assessment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.assessment.model.Course;
import com.assessment.assessment.service.CourseService;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/allAvailableCources", method = RequestMethod.GET)
	public List<Course> getallAvailableCources() {
		List<Course> courses = new ArrayList<>();
		courses = (List<Course>) courseService.findallAvailableCources();
		return courses;
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public Course register(@RequestBody Course course) {
		Course addedCourse = null;
		if (course.getId() == null) {
			if (course.getName() != null && course.getInstructor() != null && course.getDescription() != null) {
				course.setLastUpdate(new Date());
				course.setPublishDate(new Date());
				addedCourse = courseService.save(course);
			}
		} else {
			course.setLastUpdate(new Date());
			addedCourse = courseService.save(course);
		}

		return addedCourse;
	}

}
