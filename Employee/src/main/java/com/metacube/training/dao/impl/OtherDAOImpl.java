package com.metacube.training.dao.impl;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.dao.OtherDAO;
import com.metacube.training.mapper.EmployeeMapper;
import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.LoginCommands;
import com.metacube.training.model.commands.PlanCommand;
import com.metacube.training.model.commands.VehicleCommand;

@Repository
public class OtherDAOImpl implements OtherDAO {

	EmployeeDAO employeeDao;
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_VEHICLE = "insert into veichle values(?,?,?,?,?)";
	private final String SQL_INSERT_PLAN = "insert into plan values(?,?,?)";
	private final String SQL_FIND_TYPE = "select type from veichle where rid = ? ";
	private final String SQL_FIND_VEHICLE = "select * from veichle where rid = ?";
	private final String SQL_FIND_PLAN = "select * from plan where rid = ?";

	@Autowired
	public OtherDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public int check(int id) {
		if (jdbcTemplate.queryForList(SQL_FIND_VEHICLE, id).size() == 0) {
			return 0;
		} else if (jdbcTemplate.queryForList(SQL_FIND_PLAN, id).size() == 0) {
			return 1;
		} else {
			return 2;
		}
	}

	@Override
	public String getType(int id) {
		String result = (String) jdbcTemplate.queryForList(SQL_FIND_TYPE, id).get(0).get("type");
		return result;
	}
}
