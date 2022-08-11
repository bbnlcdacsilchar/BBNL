package com.bbnl.controller;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.bbnl.entity.User;
import com.bbnl.service.UserService;


@Controller
public class UserManagementController {
	
	
	
	UserService service;
	
	public UserManagementController(UserService service) {
		this.service = service;
	}
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute("users") User user) {
		
		user.setRole("ROLE_USER");
		user.setStatus(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		service.saveUser(user);
		return "redirect:/user_list?success";
	}
	
	@GetMapping("/edit/{userId}")
	public String editForm(@PathVariable("userId") String id, Model model,User user) {
		user = service.getUserById(id);
		model.addAttribute("user", user);
		return "update";
	}
	
	@GetMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") String id) {
		service.deleteUserById(id);
		return "redirect:/user_list";
	}
	
	@GetMapping("/user_list")
	public String viewAllUser(Model model){
		
	     List<User> user = service.listAllUser();
	     model.addAttribute("users", user);
	     return "userlist";
	}
	
//===================================================================================================================
	
	
	
	

}
