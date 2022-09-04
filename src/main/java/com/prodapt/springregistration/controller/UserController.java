package com.prodapt.springregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodapt.springregistration.entities.User;
import com.prodapt.springregistration.entities.UserDetails;
import com.prodapt.springregistration.exceptions.InvalidCredentialsException;
import com.prodapt.springregistration.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/index")
	public String showRegistrationForm(@ModelAttribute("user") User user,
			@ModelAttribute("userdetails") UserDetails userdetails) {
		return "index";
	}

	@PostMapping("/registration")
	public ModelAndView save(@ModelAttribute("user") User user,
			@ModelAttribute("userdetails") UserDetails userDetails) {
		user.setUserDetails(userDetails);
		userService.save(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registration");
		return mv;
	}
	@GetMapping("/registration")
	public String showForm(@ModelAttribute("user") User user,
			@ModelAttribute("userdetails") UserDetails userdetails) {
		return "registration";
	}

	@GetMapping("/loginform")
	public String showLoginForm(@ModelAttribute("user") User user) {
		return "login";
	}
	
	@RequestMapping("/login")
	public ModelAndView loginUser(@ModelAttribute("user") User user) {
		User usr;
		ModelAndView mv = new ModelAndView();
		try {
			usr = userService.loginUser(user);
			mv.addObject("userData", usr);
			mv.setViewName("userprofile");
		} catch (InvalidCredentialsException e) {
			mv.addObject("errormsg", "Username or Password incorrect");
			mv.setViewName("login");
		}

		return mv;
	}
	
	@GetMapping("/updateprofile")
	public String update(@ModelAttribute("user") User user, @ModelAttribute("userdetails") UserDetails userdetails) {
		return "update";
	}

	@PutMapping("/updateprofile")
	public ModelAndView updateUser(@ModelAttribute("user") User user,
			@ModelAttribute("userdetails") UserDetails userdetails) {
		user.setUserDetails(userdetails);
		
		User userData = userService.updateUser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update");
		mv.addObject("updatedData", userData);
		return mv;
	}


}
