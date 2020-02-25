package com.metacube.training.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.LoginCommands;
import com.metacube.training.model.commands.Plan;
import com.metacube.training.model.commands.PlanCommand;
import com.metacube.training.model.commands.VehicleCommand;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.PlanRepository;
import com.metacube.training.repository.VehicleRepository;
import com.metacube.training.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	PlanRepository planRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	


	@Override
	@Transactional
	public long addEmpolyee(EmployeeCommands employeeCommands) {
		EmployeeCommands employeeCommands1=employeeRepository.save(employeeCommands);
		System.out.println(employeeCommands1.getEmail()+" "+employeeCommands1.getId());

		return 0;
	}

	@Override
	@Transactional
	public EmployeeCommands getEmpolyee(long id) {
		 Optional<EmployeeCommands> opEmp = employeeRepository.findById((long) id);
			 return opEmp.get();
		 
	}



	@Override
	@Transactional
	public boolean updateEmployee(EmployeeCommands employeeCommands) {
		employeeRepository.save(employeeCommands);

		return true;
	}

	@Override
	@Transactional
	public List<EmployeeCommands> getAllEmployees(long id) {
		return (List<EmployeeCommands>)employeeRepository.findAll();
	}

	@Override
	@Transactional
	public long match(LoginCommands loginCommands) {
		EmployeeCommands employeeCommands=employeeRepository.findByEmail(loginCommands.getEmail()).get(0);
		System.out.println(employeeCommands.getEmail()+" "+employeeCommands.getId());
		return employeeCommands.getId();
	}

	@Override
	@Transactional
	public String addVehicle(VehicleCommand vehicleCommand) {
		return vehicleRepository.save(vehicleCommand).getType();
	}

	@Override
	@Transactional
	public boolean purchase(PlanCommand planCommands) {
		
		Plan plan=new Plan();
		plan.setRid(planCommands.getRid());
		plan.setPeriod(planCommands.getPeriod());
		plan.setMoney(planCommands.getPrice());
		planRepository.save(plan);
		return true;
	}

	@Override
	@Transactional
	public int check(long id) {
		int count=0;
		if(vehicleRepository.findById((long)id).isPresent())
			count++;
		if(planRepository.findById((long)id).isPresent())
			count++;
		return count;
		
	}

	public String getType(long id) {
		return vehicleRepository.findById((long)id).get().getType();
	}

	public String saveImage(EmployeeCommands empData,MultipartFile imageFile) throws IOException {
		String folder = "/Users/Bhavesh/Downloads/11-02-2020/Employee/src/main/resources/static/images/";
		byte[] bytes = imageFile.getBytes();
		Path path = Paths.get(folder + imageFile.getOriginalFilename());
		Files.write(path, bytes);
		employeeRepository.save(empData);
		return folder + imageFile.getOriginalFilename();
	}

	public String getImage(long id) {
		return employeeRepository.findById((long)id).get().getPath();
	}
}
