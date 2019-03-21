package com.assessment.assessment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.assessment.model.Course;
import com.assessment.assessment.model.CourseRegistration;
import com.assessment.assessment.service.CourseRegistrationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CourseRegistrationController {

	@Autowired
	private CourseRegistrationService courseRegistrationService;

	@RequestMapping(value = "/getYourCourses", method = RequestMethod.POST)
	public List<CourseRegistration> getUserCourses(@RequestParam Integer userId) {
		List<CourseRegistration> registedCourses = null;
		registedCourses = courseRegistrationService.getInRollCourses(userId);

		return registedCourses;
	}

	@RequestMapping(value = "/unregisterCourse", method = RequestMethod.DELETE)
	public Integer unregister(@RequestParam Integer userId, @RequestParam Integer courseId) {
		Integer isDeleted;
		isDeleted = courseRegistrationService.removeRegisteredCourse(userId, courseId);

		return isDeleted;
	}

	@RequestMapping(value = "/registerCourse", method = RequestMethod.POST)
	public CourseRegistration register(@RequestParam Integer userId, @RequestParam Integer courseId) {

		return courseRegistrationService.save(userId, courseId);
	}

}
