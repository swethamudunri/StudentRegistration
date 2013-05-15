package com.services;

import java.util.List;

import com.domain.StudentDTO;

public interface StudentService {

	List<StudentDTO> getAllTodos();

	StudentDTO createNewStud(String id, String name, String course);

	StudentDTO get(String todoId);

	void delete(String todoId);

	List<String> getCourses();

}
