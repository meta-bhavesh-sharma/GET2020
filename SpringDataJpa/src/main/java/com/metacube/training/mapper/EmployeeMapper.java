package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.commands.EmployeeCommands;

public class EmployeeMapper implements RowMapper<EmployeeCommands> {

	@Override
	public EmployeeCommands mapRow(ResultSet resultSet, int i) throws SQLException {

		EmployeeCommands user = new EmployeeCommands();
		user.setId(resultSet.getInt("Rid"));
		user.setName(resultSet.getString("name"));
		user.setEmail(resultSet.getString("email"));
		user.setOrg(resultSet.getString("org"));
		user.setContact(resultSet.getString("contact"));
		return user;
	}
}
