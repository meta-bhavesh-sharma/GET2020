package com.metacube.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.commands.StudentCommands;
import com.metacube.training.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService StudentService;

	@GetMapping("/Students")
	public ModelAndView Students() {
		List<StudentCommands> Students =  StudentService.getAllStudents();
		ModelAndView mv = new ModelAndView("Students");
		mv.addObject("students", Students);
		return mv;
		
	}
	
}



