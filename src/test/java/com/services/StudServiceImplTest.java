package com.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.dao.StudentDAO;
import com.domain.StudentDTO;

public class StudServiceImplTest {

	private StudentServiceImpl studentService;
	private StudentDAO studentDAO;

	@Before
	public void setup() {
		studentDAO = Mockito.mock(StudentDAO.class);
		studentService = new StudentServiceImpl();
		studentService.setStudentDAO(studentDAO);
	}

	@Test
	public void testCreateStud() {
		StudentDTO studentDTO = studentService.createNewStud("1", null, null);
		Mockito.verify(studentDAO).createNewStud(studentDTO);
		assertThat(studentDTO.getId(), equalTo("1"));
	}

	@Test
	public void testFindById() {
		studentService.get("1");
		Mockito.verify(studentDAO).findById("1");

	}

	@Test
	public void testGetCourses() {
		studentService.getCourses();
		Mockito.verify(studentDAO).getCourses();
	}
}
