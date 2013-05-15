package com.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentDTOs {
	public List<StudentDTO> student = new ArrayList<StudentDTO>();

	public StudentDTOs() {
	}

	public StudentDTOs(List<StudentDTO> students) {
		super();
		this.student = students;
	}
}
