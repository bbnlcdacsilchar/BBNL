package com.bbnl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbnl.entity.ServiceType;

import com.bbnl.repository.ServiceTypeRepository;


@Service
public class ServiceTypeService {
	@Autowired
	private ServiceTypeRepository serviceTypeRepository;

	public List<ServiceType> listAllService() {
		return serviceTypeRepository.findAll();
	}



}
