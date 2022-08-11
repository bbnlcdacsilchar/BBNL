package com.bbnl.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bbnl.entity.CustomerRequestForm;
import com.bbnl.entity.Demand;
import com.bbnl.entity.User;
import com.bbnl.repository.CustomerRequestRepository;
import com.bbnl.repository.DemandRepository;
import com.bbnl.repository.UserRepository;
import com.bbnl.utility.UserExcelSheetImporter;


@Service
public class UserExcelService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private CustomerRequestRepository repos;

	@Autowired
	private DemandRepository demandRepo;

	public void saveExcel(MultipartFile file)  {
		
		List<CustomerRequestForm> users;
		try {
			users = UserExcelSheetImporter.convertExcelToListOfUsers(file.getInputStream());
			this.repos.saveAll(users);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<User> getAllUsers() {
		return this.repo.findAll();
	}

//===================================================================================================

	

	public List<CustomerRequestForm> getAllCustomer() {
		return this.repos.findAll();
	}

	public List<Demand> getAllDemand() {
		return this.demandRepo.findAll();
	}

}
