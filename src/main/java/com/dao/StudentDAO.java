package com.dao;

import java.util.List;

import com.domain.StudentDTO;

public interface StudentDAO {

	List<StudentDTO> getAllTodos();

	StudentDTO createNewStud(StudentDTO studentDTO);

	StudentDTO findById(String todoId);

	void delete(String todoId);

	List<String> getCourses();

	
}
