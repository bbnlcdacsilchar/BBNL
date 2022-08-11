package com.bbnl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbnl.entity.District;
import com.bbnl.repository.DistrictRepository;

@Service
public class DistrictService {
	
	@Autowired
	private DistrictRepository districtRepository;
	
	public List<District> listAllDistrict() {
		return districtRepository.findAll();
	}

}
