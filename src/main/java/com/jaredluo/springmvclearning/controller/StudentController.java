package com.jaredluo.springmvclearning.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

	@RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
	public String add() {
		return "admin/add";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Student student) {

		logger.info("====save student====");
		logger.info(ReflectionToStringBuilder.toString(student));

		return "redirect:viewWithPath/" + student.getStudentName();
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "admin/upload";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		if (!file.isEmpty()) {
			logger.info("uploaded file's origin name: " + file.getOriginalFilename());
			File destFile = new File(request.getSession().getServletContext().getRealPath("/"),
					System.currentTimeMillis() + file.getOriginalFilename());
			logger.info("dest file path:{}", destFile.getAbsolutePath());
			OutputStream outputStream = new FileOutputStream(destFile);
			FileCopyUtils.copy(file.getInputStream(), outputStream);
		}
		return "admin/upload_success";
	}

	@RequestMapping(value = "/viewWithJson/{studentName}", method = RequestMethod.GET)
	public @ResponseBody Student viewStudentWithJson(@PathVariable String studentName) {
		return studentService.getStudentByName(studentName);
	}

	@RequestMapping(value = "/viewWithResponse", method = RequestMethod.GET)
	public ResponseEntity<Student> viewStudentWithResponse(@RequestParam String studentName) {
		Student student = studentService.getStudentByName(studentName);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

}
