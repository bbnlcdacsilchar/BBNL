package com.bbnl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbnl.entity.RegisteredDocuments;
import com.bbnl.repository.RegisteredDocumentsRepository;

@Service
public class RegisteredDocumentsService {
	
	@Autowired
	RegisteredDocumentsRepository repo;
	
	public List<RegisteredDocuments> listAll(){
		return repo.findAll();
	}
	
	public RegisteredDocuments save(RegisteredDocuments registeredDocuments) {
		System.out.println("registered "+registeredDocuments);
		return repo.save(registeredDocuments);
	}

	public RegisteredDocuments editRedistereddocuments(Long id) {
		return repo.findById(id).get();
		
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
		
	}
}
