package com.jaredluo.springmvclearning.service;

import org.springframework.stereotype.Service;

import com.jaredluo.springmvclearning.model.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	public Student getStudentByName(String name) {
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentAge(29);
		student.setStudentClass("4班");
		return student;
	}

}
