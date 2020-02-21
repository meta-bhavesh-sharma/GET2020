package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.LoginCommands;
import com.metacube.training.model.commands.PlanCommand;
import com.metacube.training.model.commands.VehicleCommand;

public interface EmployeeDAO {

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	int addEmpolyee(EmployeeCommands employeeCommands);

	/**
	 * 
	 * @param id
	 * @return
	 */
	EmployeeCommands getEmpolyee(int id);


	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	boolean updateEmployee(EmployeeCommands employeeCommands);

	/**
	 * 
	 * @return
	 */
	public List<EmployeeCommands> getAllEmployees(int id);

	
}
