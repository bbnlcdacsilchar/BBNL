package com.bbnl.controller;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bbnl.entity.CustomerRequestForm;
import com.bbnl.entity.User;
import com.bbnl.service.CustomerRequestService;

@Controller
public class CustomerRequestController {
	
	private CustomerRequestService service;
	
	public CustomerRequestController(CustomerRequestService service) {
		super();
		this.service = service;
	}

	@GetMapping("/crf_list")
	public String viewAllUser(Model model){
		
	     List<CustomerRequestForm> crf = service.viewAllCR();
	     model.addAttribute("users", crf);
	     return "crflist";
	}
	
	@PostMapping("/update_crf")
	public String updateCRF(@ModelAttribute("users") CustomerRequestForm user) {
		
		service.CustomerRequestSave(user);
		return "redirect:/crf_list?success";
	}
	
	@PostMapping("/save_crf")
	public String saveCRF(@ModelAttribute("users") CustomerRequestForm user) {
		
		service.CustomerRequestSave(user);
		return "/crf_list";
	}
	
	@GetMapping("/edit_crf/{crfId}")
	public String editCRForm(@PathVariable("crfId") Integer id, Model model) {
		CustomerRequestForm crf = service.getUserById(id);
		model.addAttribute("user", crf);
		return "update";
	}
	
	@GetMapping("/delete_crf/{crfId}")
	public String deleteUser(@PathVariable("crfId") Integer id) {
		service.deleteUserById(id);
		return "redirect:/crf_list";
	}

}
