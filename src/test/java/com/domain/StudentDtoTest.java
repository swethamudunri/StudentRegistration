package com.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StudentDtoTest {

	@Test
	public void testStudentDTO() {
		StudentDTO studentDAO = new StudentDTO();
		studentDAO.setCourse("Java");
		studentDAO.setId("1");
		studentDAO.setName("abc");

		assertThat(studentDAO.getId(), equalTo("1"));
	}

}
