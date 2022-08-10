package com.bbnl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bbnl.entity.Demand;
import com.bbnl.repository.DemandRepository;

@Service
public class DemandService {

	@Autowired
	private DemandRepository demandRepository;
	
	public List<Demand> listAllDemand() {
		return demandRepository.findAll();
	}
	
	public void saveDemand(Demand demand) {
		demandRepository.save(demand);
	}
	
	public Demand editDemand(int id) {
		return demandRepository.findById(id).get();
	}
	
	public void deleteDemand(int id) {
		demandRepository.deleteById(id);
	}
}
