package com.metacube.training.dao;

import com.metacube.training.model.commands.LoginCommands;
import com.metacube.training.model.commands.PlanCommand;
import com.metacube.training.model.commands.VehicleCommand;

public interface OtherDAO {

	/**
	 * 
	 * @param loginCommands
	 * @return
	 */


	int check(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	String getType(int id);

}
