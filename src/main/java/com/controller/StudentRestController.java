package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

import com.domain.StudentDTO;
import com.domain.StudentDTOs;
import com.services.StudentService;

@Controller
@RequestMapping("restfull")
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	// curl -X GET -i http://localhost:8080/StudentReg/restfull/stud
	@RequestMapping(value = "stud", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
	StudentDTOs studentDTOs() {
		return new StudentDTOs(studentService.getAllTodos());
	}

	// curl -X GET -i http://localhost:8080/StudentReg/restfull/stud/{id}
	@RequestMapping(value = "stud/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StudentDTO findById(@PathVariable String id) {
		StudentDTO stud = studentService.get(id);
		if (stud == null)
			throw new NotFoundException();
		return stud;
	}

	// curl -X POST -i
	// http://localhost:8080/StudentReg/restfull/stud?text=studentItem
	@RequestMapping(value = "stud", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestParam String id, @RequestParam String name,
			@RequestParam String course, HttpServletRequest req,
			HttpServletResponse resp) {
		StudentDTO stud = studentService.createNewStud(id, name, course);
		StringBuffer url = req.getRequestURL().append("/{id}");
		UriTemplate uriTemplate = new UriTemplate(url.toString());
		resp.addHeader("location", uriTemplate.expand(stud.getId())
				.toASCIIString());
	}

	// curl -X DELETE -i http://localhost:8080/StudentReg/restfull/stud/{id}
	@RequestMapping(value = "stud/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		studentService.delete(id);
	}

	// curl -X PUT -i http://localhost:8080/StudentReg/restfull/stud/{id} -d
	// '{"text":"TODO Item Text","done":true}'
	@RequestMapping(value = "stud/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable String id, @RequestBody StudentDTO stud) {
		StudentDTO existing = studentService.get(id);
		if (existing == null) {
			throw new NotFoundException();
		}
	}

	public void setStudentService(StudentService service) {
		this.studentService = service;
	}

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
