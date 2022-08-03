package com.bbnl.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bbnl.entity.Block;
import com.bbnl.entity.Demand;
import com.bbnl.entity.District;
import com.bbnl.entity.GramPanchayat;
import com.bbnl.entity.State;
import com.bbnl.entity.User;
import com.bbnl.repository.UserRepository;
import com.bbnl.service.BlockService;
import com.bbnl.service.DemandService;
import com.bbnl.service.DistrictService;
import com.bbnl.service.GramPanchayatService;
import com.bbnl.service.StateService;

@Controller
@RequestMapping("/user")
public class DemandController {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private DemandService demandService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired 
	private DistrictService districtService;
	
	@Autowired 
	private BlockService blockService;
	
	@Autowired
	private GramPanchayatService gramPanchayatService;	
	
	//Showing all Connections details
	@GetMapping("/connection")
	public String connection(Model model,Principal principal) {
		String username = principal.getName();
		User user = repo.getUserByUserId(username);
		model.addAttribute("user",user);
		List<Demand> listDemand = demandService.listAllDemand();
		model.addAttribute("listDemand", listDemand);
		return "connections";
	}

	//Adding new Connection
	@GetMapping("/connection/addconnection")
	public String newConn(Model model,Principal principal) {
		
		String username = principal.getName();
		User user = repo.getUserByUserId(username);
		model.addAttribute("user",user);
		model.addAttribute("title", "Add Connection");
		
		List<State> liststate = stateService.listAllState();
		model.addAttribute("liststate", liststate);
		
		List<District> listDistrict = districtService.listAllDistrict();
		model.addAttribute("listDistrict", listDistrict);
		
		List<Block> lisBlock = blockService.listAllBlock();
		model.addAttribute("lisBlock", lisBlock);
		
		List<GramPanchayat> listGramPanchayat = gramPanchayatService.listAllGramPanchayat();
		model.addAttribute("listGramPanchayat", listGramPanchayat);
		
		model.addAttribute("demand", new Demand());
		return "newConnection";
	}
	
	//saving a new connection
	@RequestMapping(value = "/saveconn", method = RequestMethod.POST)
	public String saveConn(@ModelAttribute("demand") Demand demand) {
	 demandService.saveDemand(demand);
	 return "redirect:connection?success";
	 }
	
	//Edit connection
	@RequestMapping("connection/edit/{id}")
	public ModelAndView editConn(@PathVariable(name = "id") int id,Model model, Principal principal) {
		String username = principal.getName();
		User user = repo.getUserByUserId(username);
		model.addAttribute("user",user);
		ModelAndView mav = new ModelAndView("editConnection");
		Demand demand = demandService.editDemand(id);
		
		List<State> liststate = stateService.listAllState();
		model.addAttribute("liststate", liststate);
		
		List<District> listDistrict = districtService.listAllDistrict();
		model.addAttribute("listDistrict", listDistrict);
		
		List<Block> lisBlock = blockService.listAllBlock();
		model.addAttribute("lisBlock", lisBlock);
		
		List<GramPanchayat> listGramPanchayat = gramPanchayatService.listAllGramPanchayat();
		model.addAttribute("listGramPanchayat", listGramPanchayat);
		
		mav.addObject("demand", demand);		
		return mav;
	}
	
	//Delete Connection
	@RequestMapping("connection/delete/{id}")
	public String deleteConn(@PathVariable(name = "id") int id) {
		demandService.deleteDemand(id);
		return "redirect:/user/connection?delete";
	}
}
