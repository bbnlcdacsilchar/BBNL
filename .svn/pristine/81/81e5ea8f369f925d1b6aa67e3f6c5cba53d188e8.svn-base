package com.bbnl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbnl.entity.Block;
import com.bbnl.repository.BlockRepository;

@Service
public class BlockService {
	
	@Autowired
	private BlockRepository blockRepository;
	
	public List<Block> listAllBlock() {
		return blockRepository.findAll();
	}
}
