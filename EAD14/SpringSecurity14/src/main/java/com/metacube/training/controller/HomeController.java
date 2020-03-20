package com.metacube.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.commands.EmployeeCommands;
import com.metacube.training.model.commands.LoginCommands;
import com.metacube.training.model.commands.PlanCommand;

import com.metacube.training.model.commands.VehicleCommand;
import com.metacube.training.service.EmployeeService;

@Controller
public class HomeController {
	
	EmployeeCommands empData;
	private static long employeeId;
	private static String vehicleType;
	private static String path = "\\Users\\Bhavesh\\Downloads\\11-02-2020\\Employee\\src\\main\\resources\\static\\images\\";
	private static String imagename = "download.jpg";
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private LoginCommands loginCommands;

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		return "home";
	}

	@GetMapping({ "/Mr_baba_17" })
	public String home1(Model model) {
		return "adminhome";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("employeeLogin", new LoginCommands());

		return "login";
	}

	@GetMapping({ "/user" })
	public String home2(Model model ,HttpSession session, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		userDetail.getUsername();
		System.out.println(userDetail.getUsername());
		System.out.println(userDetail.getPassword());
		loginCommands.setEmail(userDetail.getUsername());
		loginCommands.setPassword(userDetail.getPassword());
		employeeId = employeeService.match(loginCommands);
		System.out.println(employeeId);
		session = request.getSession();
		session.setAttribute("email", loginCommands.getEmail());
		session.setAttribute("Id", employeeId);
		if (employeeService.check(employeeId) == 0) {
			model.addAttribute("vehicleData", new VehicleCommand());
			return ("vehicle");
		} else if (employeeService.check(employeeId) == 1) {
			vehicleType = employeeService.getType(employeeId);
			return ("redirect:/plan");
		} else if (employeeService.check(employeeId) == 2) {
			return ("redirect:/userhome");
		} else {
		return "home";
		}
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("employee", new EmployeeCommands());
		return "signup";
	}
	@GetMapping("/addemployee")
	public String addEmp(Model model) {
		model.addAttribute("employee", new EmployeeCommands());
		return "addemployee";
	}

	@GetMapping("/vehicle")
	public ModelAndView vehicle(Model model, HttpSession session, HttpServletResponse response) throws IOException {
		String email = (String) session.getAttribute("email");
		if (email == null) {
			response.sendRedirect("login");
		}
		model.addAttribute("vehicleData", new VehicleCommand());
		ModelAndView mav = new ModelAndView("vehicle");
		mav.addObject("Eid", employeeId);
		return mav;
	}

	@GetMapping("/userhome")
	public ModelAndView userhome(Model model, HttpSession session, HttpServletResponse response) throws IOException {
		String email = (String) session.getAttribute("email");
		if (email == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		}
		if (employeeId == 0) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		}
		model.addAttribute("userData", new EmployeeCommands());
		EmployeeCommands user = employeeService.getEmpolyee(employeeId);
		empData = user;
		ModelAndView mav = new ModelAndView("userhome");
		imagename = employeeService.getImage(employeeId);
		mav.addObject("Data", user);
		mav.addObject("IMAGE", path + imagename);
		return mav;
	}

	@GetMapping("/employees")
	public ModelAndView employees(HttpSession session, HttpServletResponse response) throws IOException {
		String email = (String) session.getAttribute("email");
		if (email == null) {
			response.sendRedirect("login");
		}

		List<EmployeeCommands> employees = employeeService.getAllEmployees(employeeId);
		return new ModelAndView("employees", "employees", employees);
	}

	@GetMapping("/allemployees")
	public ModelAndView getEmployees() {

		List<EmployeeCommands> employees = employeeService.getAllEmployees();
		return new ModelAndView("allemployees", "employees", employees);
	}
	@GetMapping("/allemployees/{id}")
	public ModelAndView employees(@PathVariable("id") long id) {
		return new ModelAndView("update","employee",employeeService.getEmpolyee(id));
	}
	
	@GetMapping("/allemployees/delete/{id}")
	public String deleteEmployee(@PathVariable("id") long id) {
			employeeService.deleteEmployee(id);
		return "redirect:/allemployees";
	}

	@GetMapping("/userlogout")
	public String logout(HttpSession session) {
		session.invalidate();
		employeeId = 0;
		vehicleType = null;

		return "redirect:/userlogin";
	}

	@GetMapping("/plan")
	public ModelAndView plan(Model model, HttpSession session, HttpServletResponse response) throws IOException {
		// if(employeeId==0)
		// return new ModelAndView("redirect:/login");
		String email = (String) session.getAttribute("email");
		if (email == null) {
			response.sendRedirect("login");
		}
		int dailyPrice = 0;
		int monthlyPrice = 0;
		int yearlyPrice = 0;
		model.addAttribute("planData", new PlanCommand());
		ModelAndView mav = new ModelAndView("plan");
		mav.addObject("Rid", employeeId);
		if ("Cycle".equals(vehicleType)) {
			dailyPrice = 5;
			monthlyPrice = 100;
			yearlyPrice = 500;
		}

		if ("Bike".equals(vehicleType)) {

			dailyPrice = 10;
			monthlyPrice = 200;
			yearlyPrice = 1000;
		}
		if ("Car".equals(vehicleType)) {
			dailyPrice = 20;
			monthlyPrice = 500;
			yearlyPrice = 3500;
		}
		mav.addObject("daily", dailyPrice);
		mav.addObject("monthly", monthlyPrice);
		mav.addObject("yearly", yearlyPrice);
		return mav;
	}
	
	@PostMapping("/addemployee")
	public ModelAndView doAddEmp(@Validated @ModelAttribute("employee") EmployeeCommands employeeCommands,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("signup");
			return mav;
		} else {
			if (!employeeCommands.getPassword().equals(employeeCommands.getConfirmPassword())) {
				ModelAndView mav = new ModelAndView("signup");
				mav.addObject("MATCHPASS", "Password And Confirm password Are Not Same");
				return mav;
			} else if (employeeCommands.getId() == 0) {
				employeeService.addEmpolyee(employeeCommands);
				ModelAndView mav = new ModelAndView("redirect:/adminhome");
				return mav;
			} else {
				employeeService.updateEmployee(employeeCommands);
				ModelAndView mav = new ModelAndView("redirect:/adminhome");
				return mav;
			}

		}

	}
	@PostMapping("/signup")
	public ModelAndView doSignup(@Validated @ModelAttribute("employee") EmployeeCommands employeeCommands,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("signup");
			return mav;
		} else {
			if (!employeeCommands.getPassword().equals(employeeCommands.getConfirmPassword())) {
				ModelAndView mav = new ModelAndView("signup");
				mav.addObject("MATCHPASS", "Password And Confirm password Are Not Same");
				return mav;
			} else if (employeeCommands.getId() == 0) {
				employeeService.addEmpolyee(employeeCommands);
				ModelAndView mav = new ModelAndView("redirect:/user");
				return mav;
			} else {
				employeeService.updateEmployee(employeeCommands);
				ModelAndView mav = new ModelAndView("redirect:/user");
				return mav;
			}

		}

	}
	@PostMapping("/update")
	public ModelAndView doUpdate(@Validated @ModelAttribute("employee") EmployeeCommands employeeCommands,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("signup");
			return mav;
		} else {
			if (!employeeCommands.getPassword().equals(employeeCommands.getConfirmPassword())) {
				ModelAndView mav = new ModelAndView("signup");
				mav.addObject("MATCHPASS", "Password And Confirm password Are Not Same");
				return mav;
			} else {
				employeeService.updateEmployee(employeeCommands);
				ModelAndView mav = new ModelAndView("redirect:/allemployees");
				return mav;
			}

		}

	}

	@PostMapping("/vehicle")
	public ModelAndView registerVehicle(@Validated @ModelAttribute("vehicleData") VehicleCommand vehicleCommands,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("vehicle");
			return mav;
		} else {
			vehicleCommands.setEid(employeeId);
			String s = employeeService.addVehicle(vehicleCommands);
			if (s == null) {
				model.addAttribute("userData", new EmployeeCommands());
				EmployeeCommands user = employeeService.getEmpolyee(employeeId);
				empData = user;
				ModelAndView mav = new ModelAndView("userhome");
				mav.addObject("Data", user);
				mav.addObject("IMAGE", imagename);
				mav.addObject("MESSAGE", "Allready Registered");
				return mav;
			} else {
				vehicleType = s;
				ModelAndView mav = new ModelAndView("redirect:/plan");
				return mav;
			}
		}
	}

	@PostMapping("/plan")
	public ModelAndView registerPlan(@Validated @ModelAttribute("planData") PlanCommand planCommands,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("plan");
			return mav;
		} else {
			if (employeeService.purchase(planCommands)) {
				ModelAndView mav = new ModelAndView("redirect:/userhome");
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("redirect:/userhome");
				return mav;
			}
		}
	}

	@PostMapping("/userhome")
	public String update(@Validated @ModelAttribute("userData") EmployeeCommands employeeCommands,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "userhome";
		} else {
			if (employeeService.updateEmployee(employeeCommands))
				return "redirect:/userhome";
			else
				return "redirect:/userhome";
		}
	}

	@PostMapping("/setimage")
	public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile, Model model) throws IOException {
		System.out.println("Upload image...");
		empData.setPath(imageFile.getOriginalFilename());
		String path = employeeService.saveImage(empData, imageFile);
		model.addAttribute("userData", empData);
		imagename = path;
		model.addAttribute("IMAGE", imagename);

		return "userhome";
	}

}
