package com.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.domain.StudentDTO;
import com.services.StudentService;

public class RestControllerTest {
	StudentService service;
	StudentRestController controller;

	@Before
	public void setup() {
		service = Mockito.mock(StudentService.class);
		controller = new StudentRestController();
		controller.setStudentService(service);
	}

	@Test
	public void testDelete() {
		controller.delete("1");
	}

	@Test(expected = NotFoundException.class)
	public void testDetails() {
		StudentDTO dto = new StudentDTO();
		dto.setId("1");
		dto.setCourse("abc");
		dto = controller.findById("1");
		Mockito.verify(service).get("1");
		assertThat(dto.getId(), equalTo("1"));
	}
}
