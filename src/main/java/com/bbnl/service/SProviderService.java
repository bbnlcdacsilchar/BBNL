package com.bbnl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbnl.entity.ServiceProvider;
import com.bbnl.repository.ServiceProviderRepository;

@Service
public class SProviderService {
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	
	public List<ServiceProvider> listAll(){
		return serviceProviderRepository.findAll();
	}
	   
	public void save(ServiceProvider serviceProvider) {
		serviceProviderRepository.save(serviceProvider);
	}
	
	public ServiceProvider get(Long id) {
		return serviceProviderRepository.findById(id).get();
		
	}
	
	public void delete(Long id) {
		serviceProviderRepository.deleteById( id);
		
	}
	
}
