package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.commands.StudentCommands;

public class StudentMapper implements RowMapper<StudentCommands> {

	@Override
	public StudentCommands mapRow(ResultSet resultSet, int i) throws SQLException {

		StudentCommands user = new StudentCommands();
		user.setFirstName(resultSet.getString("first_name"));
		user.setLastName(resultSet.getString("last_name"));
		user.setFatherName(resultSet.getString("father_name"));
		user.setEmail(resultSet.getString("email"));
		user.setStudentClass(resultSet.getInt("class"));
		user.setAge(resultSet.getInt("age"));
		return user;
	}
}

