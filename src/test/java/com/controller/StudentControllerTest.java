package com.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import com.domain.StudentDTO;
import com.services.StudentService;

public class StudentControllerTest {
	StudentService service;
	StudentController controller;

	@Before
	public void setup() {
		service = Mockito.mock(StudentService.class);
		controller = new StudentController();
		controller.setStudentService(service);
	}

	@Test
	public void testCreateStud() {

		Model model = Mockito.mock(Model.class);

		controller.create("1", "abc", "java", model);
		Mockito.verify(model).addAttribute("studentServices",
				new LinkedList<StudentDTO>());
		Mockito.verify(service).createNewStud("1", "abc", "java");
	}

	@Test
	public void testCoursesOffered() {

		Model model = Mockito.mock(Model.class);

		String studentDTO = controller.coursesOffered(model);
		Mockito.verify(model).addAttribute("courses",
				new LinkedList<StudentDTO>());
		Mockito.verify(service).getCourses();
		assertThat(studentDTO, equalTo("CourseDetails"));
	}

	@Test
	public void testDetails() {

		Model model = Mockito.mock(Model.class);

		String studentDTO = controller.details("1", model);
		Mockito.verify(model).addAttribute("studentServices", null);
		Mockito.verify(service).get("1");
		assertThat(studentDTO, equalTo("StudDetails"));
	}
}
