package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.domain.StudentDTO;
import com.services.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/register")
	public String create(@RequestParam String id, @RequestParam String name,
			@RequestParam String course, Model model) {
		studentService.createNewStud(id, name, course);
		model.addAttribute("studentServices", studentService.getAllTodos());
		return "RegSucess";
	}

	@RequestMapping("/details")
	public String details(@RequestParam String id, Model model) {
		StudentDTO studentDTO = studentService.get(id);
		model.addAttribute("studentServices", studentDTO);
		return "StudDetails";
	}

	@RequestMapping("/courses")
	public String coursesOffered(Model model) {

		model.addAttribute("courses", studentService.getCourses());
		return "CourseDetails";
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
