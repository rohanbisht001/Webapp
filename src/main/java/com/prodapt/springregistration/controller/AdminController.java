package com.prodapt.springregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prodapt.springregistration.entities.User;
import com.prodapt.springregistration.entities.UserDetails;
import com.prodapt.springregistration.exceptions.InvalidCredentialsException;
import com.prodapt.springregistration.service.UserDetailsService;
import com.prodapt.springregistration.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping("/adminlogin")
	public ModelAndView loginAdmin(@ModelAttribute("user") User user) throws InvalidCredentialsException {
		User usr;
		ModelAndView mv = new ModelAndView();
		usr = userService.loginUser(user);
		mv.addObject("userData", usr);
		mv.setViewName("adminlogged");

		return mv;
	}

	@GetMapping("/admin")
	public String showLoginForm(@ModelAttribute("user") User user) {
		return "admin";
	}

	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute("userdetails") UserDetails userdetails) {
		ModelAndView mv = new ModelAndView();
		List<UserDetails> users = userDetailsService.getList();
		mv.setViewName("list");
		mv.addObject("listOfUsers", users);
		return mv;
	}

	@GetMapping("/delete")
	public String delete(@ModelAttribute("user") User user) {
		return "delete";
	}

	@DeleteMapping("/deleteuser")
	public ModelAndView deleteUser(@ModelAttribute("user") User user) {
		userService.deleteUserById(user.getUserId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delete");
		mv.addObject("msg", "Deleted Successfully");
		return mv;

	}

}