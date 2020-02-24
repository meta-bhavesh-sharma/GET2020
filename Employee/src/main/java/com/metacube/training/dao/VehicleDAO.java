package com.metacube.training.dao;

import com.metacube.training.model.commands.VehicleCommand;

public interface VehicleDAO {

	/**
	 * 
	 * @param loginCommands
	 * @return
	 */

	String addVehicle(VehicleCommand vehicleCommand);
	
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
