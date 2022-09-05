package com.prodapt.springregistration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@Autowired(required = false)
	private UserDetailsService userDetailsService;

	@PostMapping("/adminlogin")
	public ModelAndView loginAdmin(@ModelAttribute("user") User user) {
		User usr;
		ModelAndView mv = new ModelAndView();
		try {
			usr = userService.loginUser(user);
			mv.addObject("userData", usr);
			mv.setViewName("adminprofile");
		} catch (InvalidCredentialsException e) {
			mv.addObject("errormssg", "Username or Password incorrect");
			mv.setViewName("admin");
		}

		return mv;
	}

	@GetMapping("/admin")
	public String showLoginForm(@ModelAttribute("user") User user) {
		return "admin";
	}

	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute("userdetails") UserDetails userDetails) {
		ModelAndView mav = new ModelAndView();
		List<UserDetails> users = userDetailsService.listAll();
		mav.setViewName("list");
		mav.addObject("listOfUsers", users);
		return mav;
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

	@GetMapping("/adduser")
	public String showForm(@ModelAttribute("user") User user, @ModelAttribute("userdetails") UserDetails userdetails) {
		return "registration";
	}

	@PostMapping("/newuser")
	public ModelAndView save(@ModelAttribute("user") User user,
			@ModelAttribute("userdetails") UserDetails userDetails) {
		user.setUserDetails(userDetails);
		userService.save(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registration");
		return mv;
	}

	@GetMapping("/edit")
	public String edit(@ModelAttribute("user") User user, @ModelAttribute("userdetails") UserDetails userdetails) {
		return "edit_user";
	}

	@PutMapping("/edituser")
	public ModelAndView editUser(@ModelAttribute("user") User user,
			@ModelAttribute("userdetails") UserDetails userdetails) {
		user.setUserDetails(userdetails);
		User userData = userService.editUser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit_user");
		mv.addObject("updatedData", userData);
		return mv;
	}

//	@RequestMapping("/delete")
//	public String deleteCustomerForm(@RequestParam long id) {
//		userService.delete(id);
//		return "redirect:/list";
//	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<User> result = userService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		return mav;
	}
}