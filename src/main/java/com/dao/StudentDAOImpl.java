package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.domain.StudentDTO;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("dataSource")
	public void setJdbcTemplate(DataSource dataSource) {
		System.out.println("Constructor");
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public List<StudentDTO> getAllTodos() {
		String query = "SELECT * FROM STUDENT";
		List<StudentDTO> studentDTOs = jdbcTemplate.query(query,
				new RowMapper<StudentDTO>() {
					public StudentDTO mapRow(ResultSet rs, int arg1)
							throws SQLException {
						StudentDTO studentDTO = new StudentDTO();
						studentDTO = new StudentDTO();
						studentDTO.setName(rs.getString("name"));
						studentDTO.setId(rs.getString("id"));
						studentDTO.setCourse(rs.getString("course"));
						return studentDTO;
					}
				});
		// return (List<User>) list;
		return studentDTOs;
	}

	public void delete(String studID) {
		String sql = "DELETE FROM STUDENT WHERE ID ='" + studID + "'";
		jdbcTemplate.execute(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.StudentDAO#getCourses()
	 */
	public List<String> getCourses() {
		String query = "SELECT * FROM COURSES";
		List<String> courses = jdbcTemplate.query(query,
				new RowMapper<String>() {
					public String mapRow(ResultSet rs, int arg1)
							throws SQLException {
						return rs.getString("COURSE");
					}
				});
		// return (List<User>) list;
		return courses;
	}

	public StudentDTO createNewStud(StudentDTO studentDTO) {
		String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] { studentDTO.getId(), studentDTO.getName(),
						studentDTO.getCourse() });
		return null;
	}

	public StudentDTO findById(String todoId) {
		System.out.println("GetRecor");
		return jdbcTemplate.query("SELECT * FROM STUDENT WHERE ID = ?",
				new Object[] { todoId }, new ResultSetExtractor<StudentDTO>() {
					public StudentDTO extractData(ResultSet rs)
							throws SQLException {
						StudentDTO studentDTO = null;
						if (rs.next()) {
							studentDTO = new StudentDTO();
							studentDTO.setName(rs.getString("NAME"));
							studentDTO.setId(rs.getString("ID"));
							studentDTO.setCourse(rs.getString("COURSE"));

						}
						return studentDTO;
					}
				});
	}

}
