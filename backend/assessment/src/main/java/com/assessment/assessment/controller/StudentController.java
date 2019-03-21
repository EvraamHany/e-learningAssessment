package com.assessment.assessment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.assessment.model.Student;
import com.assessment.assessment.repository.StudentRepository;
import com.assessment.assessment.service.StudentService;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Student login(@RequestParam String username, @RequestParam String password) {
		Student foundStudent = new Student();
		foundStudent = studentService.findByUsernameAndPassword(username, password);
		return foundStudent;
	}

	@RequestMapping(value = "/allStudent", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		students = (List<Student>) studentRepository.findAll();
		return students;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Student register(@RequestBody Student student) {
		Student addedStudent = null;
		if (student.getId() == null) {
			if (student.getName() != null && student.getUsername() != null && student.getPassword() != null)
				addedStudent = studentService.addStudent(student);
		}

		return addedStudent;
	}

}
