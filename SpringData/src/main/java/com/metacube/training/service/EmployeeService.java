package com.metacube.training.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.LoginCommands;
import com.metacube.training.model.commands.PlanCommand;
import com.metacube.training.model.commands.VehicleCommand;

/**
 * Service contains methods to employee operations
 * 
 *
 */
public interface EmployeeService {

	/**
	 * 
	 * @param employeeCommands
	 * @return
	 */
	long addEmpolyee(EmployeeCommands employeeCommands);

	/**
	 * 
	 * @param id
	 * @return
	 */
	EmployeeCommands getEmpolyee(long id);

	/**
	 * 
	 * @param id
	 * @return
	 */

	boolean updateEmployee(EmployeeCommands employeeCommands);

	/**
	 * 
	 * @return
	 */
	List<EmployeeCommands> getAllEmployees(long id);

	/**
	 * 
	 * @param loginCommands
	 * @return
	 */
	long match(LoginCommands loginCommands);

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
	int check(long id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	String getType(long id);

	/**
	 * 
	 * @param imageFile
	 */
	String saveImage(EmployeeCommands empData,MultipartFile imageFile) throws IOException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	String getImage(long id);

}
