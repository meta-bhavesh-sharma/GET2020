package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.training.model.commands.StudentCommands;
import com.metacube.training.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService StudentService;
	
	@Value("${home.message}")
	private String message;
	
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("msg",message);		
		return "home";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("Student",new StudentCommands());
		
		return "addStudent";
	}
	
	@PostMapping("/addStudent")
	public String doAddStudent(@Validated @ModelAttribute("Student") StudentCommands StudentCommands,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			return "addStudent";
		} 
		else {
			StudentService.addEmpolyee(StudentCommands);
			return "redirect:/home";
		}
		

		
	}
	

	
}
