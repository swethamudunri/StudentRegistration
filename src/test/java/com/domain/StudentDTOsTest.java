package com.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StudentDTOsTest {

	@Test
	public void testStudentDTO() {
		StudentDTO studentDAO = new StudentDTO();
		studentDAO.setCourse("Java");
		studentDAO.setId("1");
		studentDAO.setName("abc");
		List<StudentDTO> dtos = new ArrayList<StudentDTO>();
		dtos.add(studentDAO);
		StudentDTOs studentDTOs = new StudentDTOs(dtos);

		assertThat(studentDTOs.student.get(0).getId(), equalTo("1"));
	}

}
