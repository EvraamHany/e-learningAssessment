package com.assessment.assessment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.assessment.model.Student;
import com.assessment.assessment.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {

		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);

		return students;
	}

	public void save(Student student) {

		studentRepository.save(student);

	}

	public Student findByUsernameAndPassword(String username, String password) {

		Student student = studentRepository.findByUsernameAndPassword(username, password);
		return student;

	}

	public Student addStudent(Student student) {

		Student addedStudent = studentRepository.save(student);

		return addedStudent;

	}

}
