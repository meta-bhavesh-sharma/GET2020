package com.metacube.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.training.model.commands.StudentCommands;
import com.metacube.training.service.StudentService;

@RestController
public class StudentRestController {


	@Autowired
	private StudentService StudentService;
	
	@GetMapping("/Students-rest")
	public List<StudentCommands> StudentsRest() {
		return StudentService.getAllStudents();
	}
}
