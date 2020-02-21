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
	int match(LoginCommands loginCommands);

	/**
	 * 
	 * @param vehicleCommand
	 * @return
	 */
	String addVehicle(VehicleCommand vehicleCommand);

	/**
	 * 
	 * @param planCommands
	 * @return
	 */
	boolean purchase(PlanCommand planCommands);

	/**
	 * 
	 * @param id
	 * @return
	 */
	int check(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	String getType(int id);

	/**
	 * 
	 * @param fileName
	 * @param id
	 */
	void saveImage(String fileName, int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	 String getImage(int id);
}
