package com.bbnl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbnl.entity.State;
import com.bbnl.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public List<State> listAllState(){
		return stateRepository.findAll();
	}
}
