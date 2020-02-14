package com.metacube.training.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.StudentDAO;
import com.metacube.training.mapper.StudentMapper;
import com.metacube.training.model.commands.StudentCommands;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;

	private final String SQL_GET_ALL = "select * from std";
	private final String SQL_INSERT_USER = "insert into std values(?,?,?,?,?,?)";

	@Autowired
	public StudentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addStudent(StudentCommands StudentCommands) {
		return jdbcTemplate.update(SQL_INSERT_USER, StudentCommands.getFirstName(),StudentCommands.getLastName(),StudentCommands.getFatherName(), StudentCommands.getEmail(),StudentCommands.getStudentClass(),StudentCommands.getAge());
	}
	
	@Override
	public List<StudentCommands> getAllStudents() {
		
		return jdbcTemplate.query(SQL_GET_ALL, new StudentMapper());
	}

}
