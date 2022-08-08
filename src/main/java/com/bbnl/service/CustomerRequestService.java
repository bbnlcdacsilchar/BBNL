package com.bbnl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbnl.entity.CustomerRequestForm;
import com.bbnl.repository.CustomerRequestRepository;

@Service
public class CustomerRequestService {
	
	@Autowired
	private CustomerRequestRepository repo;

	
	
	public List<CustomerRequestForm> viewAllCR(){
		return repo.findAll();
	}



	public CustomerRequestForm CustomerRequestSave(CustomerRequestForm user) {
		
		return repo.save(user);
	}



	@SuppressWarnings("deprecation")
	public CustomerRequestForm getUserById(Integer id) {
		return repo.getById(id);
	}



	@SuppressWarnings("deprecation")
	public void deleteUserById(Integer id) {
		CustomerRequestForm byId = repo.getById(id);
		repo.delete(byId);
		
	}
	
	

}
