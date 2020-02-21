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

	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_VEHICLE = "insert into veichle values(?,?,?,?,?)";
	private final String SQL_INSERT_PLAN = "insert into plan values(?,?,?)";
	private final String SQL_FIND_ID = "select Rid from emp where email = ? AND password = ? ";
	private final String SQL_FIND_TYPE = "select type from veichle where rid = ? ";
	private final String SQL_FIND_VEHICLE = "select * from veichle where rid = ?";
	private final String SQL_FIND_PLAN = "select * from plan where rid = ?";
	private final String SQL_UPDATE_IMAGE = "update  emp set image= ? where Rid = ?";
	private final String SQL_FIND_IMAGE = "select image from emp where Rid = ?";

	@Autowired
	public OtherDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int match(LoginCommands loginCommands) {
		List i = jdbcTemplate.queryForList(SQL_FIND_ID, loginCommands.getEmail(), loginCommands.getPassword());
		if (i.size() == 0) {
			return 0;
		}
		int result = (int) jdbcTemplate.queryForList(SQL_FIND_ID, loginCommands.getEmail(), loginCommands.getPassword())
				.get(0).get("Rid");
		return result;
	}

	@Override
	public String addVehicle(VehicleCommand vehicleCommand) {
		if (!(jdbcTemplate.queryForList(SQL_FIND_VEHICLE, vehicleCommand.getEid()).size() == 0)) {
			return null;
		}
		int Result = jdbcTemplate.update(SQL_INSERT_VEHICLE, vehicleCommand.getEid(), vehicleCommand.getVehicleName(),
				vehicleCommand.getType(), vehicleCommand.getVehicleNumber(), vehicleCommand.getIdentification());
		if (Result > 0) {
			String result = (String) jdbcTemplate.queryForList(SQL_FIND_TYPE, vehicleCommand.getEid()).get(0)
					.get("type");
			return result;
		} else {
			return "Failed";
		}
	}

	@Override
	public boolean purchase(PlanCommand planCommands) {
		if (!(jdbcTemplate.queryForList(SQL_FIND_PLAN, planCommands.getRid()).size() == 0)) {
			return false;
		}
		return jdbcTemplate.update(SQL_INSERT_PLAN, planCommands.getRid(), planCommands.getPrice(),
				planCommands.getPeriod()) > 0;
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

	@Override
	public void saveImage(String fileName, int id) {
		jdbcTemplate.update(SQL_UPDATE_IMAGE, fileName, id);
	}

	@Override
	public String getImage(int id) {
		String result = (String) jdbcTemplate.queryForList(SQL_FIND_IMAGE, id).get(0).get("image");
		return result;
	}
}
