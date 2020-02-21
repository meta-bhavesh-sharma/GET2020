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
 * @author ankush
 *
 */
public interface EmployeeService {

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
	 * @param id
	 * @return
	 */

	boolean updateEmployee(EmployeeCommands employeeCommands);

	/**
	 * 
	 * @return
	 */
	List<EmployeeCommands> getAllEmployees(int id);

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
	 * @param imageFile
	 */
	String saveImage(MultipartFile imageFile, int id) throws IOException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	String getImage(int id);

}
