package com.jaredluo.springmvclearning.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaredluo.springmvclearning.model.Student;
import com.jaredluo.springmvclearning.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewStudent(@RequestParam("studentName") String studentName, Model model) {
		logger.info("viewStudent, studentName:{}", studentName);
		Student student = studentService.getStudentByName(studentName);
		model.addAttribute(student);
		return "home";
	}

	@RequestMapping(value = "/viewWithPath/{studentName}", method = RequestMethod.GET)
	public String viewStudentWithPath(@PathVariable("studentName") String studentName, Map<String, Object> model) {
		logger.info("viewStudentWithPath, studentName:{}", studentName);
		Student student = studentService.getStudentByName(studentName);
		model.put("student", student);
		return "home";
	}

	@RequestMapping(value = "/viewWithHttp")
	public String viewStudentWithHttp(HttpServletRequest request, Model model) {
		String studentName = request.getParameter("studentName");
		logger.info("viewStudentWithHttp, studentName:{}", studentName);
		Student student = studentService.getStudentByName(studentName);
		model.addAttribute(student);
		return "home";
	}

}
