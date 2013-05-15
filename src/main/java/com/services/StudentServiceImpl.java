package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StudentDAO;
import com.domain.StudentDTO;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public List<StudentDTO> getAllTodos() {
		return studentDAO.getAllTodos();
	}

	public StudentDTO get(String todoId) {
		return studentDAO.findById(todoId);
	}

	public void delete(String todoId) {
		studentDAO.delete(todoId);
	}

	public StudentDTO createNewStud(String id, String name, String course) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(id);
		studentDTO.setName(name);
		studentDTO.setCourse(course);
		studentDAO.createNewStud(studentDTO);
		return studentDTO;
	}

	public List<String> getCourses() {
		// TODO Auto-generated method stub
		return studentDAO.getCourses();
	}

}
