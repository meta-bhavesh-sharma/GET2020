package com.metacube.training.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.LoginCommands;
import com.metacube.training.model.commands.PlanCommand;
import com.metacube.training.model.commands.VehicleCommand;
import com.metacube.training.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public int addEmpolyee(EmployeeCommands employeeCommands) {
		employeeDAO.addEmpolyee(employeeCommands);

		return 0;
	}

	@Override
	public EmployeeCommands getEmpolyee(int id) {
		return employeeDAO.getEmpolyee(id);
	}

	@Override
	public boolean deleteEmployee(int id) {
		return employeeDAO.deleteEmployee(id);
	}

	@Override
	public boolean updateEmployee(EmployeeCommands employeeCommands) {

		return employeeDAO.updateEmployee(employeeCommands);
	}

	@Override
	public List<EmployeeCommands> getAllEmployees(int id) {

		return employeeDAO.getAllEmployees(id);
	}

	@Override
	public int match(LoginCommands loginCommands) {
		return employeeDAO.match(loginCommands);
	}

	public String addVehicle(VehicleCommand vehicleCommand) {
		return employeeDAO.addVehicle(vehicleCommand);
	}

	public boolean purchase(PlanCommand planCommands) {
		return employeeDAO.purchase(planCommands);
	}

	public int check(int id) {
		return employeeDAO.check(id);
	}

	public String getType(int id) {
		return employeeDAO.getType(id);
	}

	public String saveImage(MultipartFile imageFile, int id) throws IOException {
		String folder = "/Users/Bhavesh/Downloads/11-02-2020/Employee/src/main/resources/static/images/";
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(folder + imageFile.getOriginalFilename());
		Files.write(path, bytes);
		employeeDAO.saveImage(imageFile.getOriginalFilename(), id);
		return folder + imageFile.getOriginalFilename();
	}

	public String getImage(int id) {
		return employeeDAO.getImage(id);
	}
}
