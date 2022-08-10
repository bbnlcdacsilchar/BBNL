package com.bbnl.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bbnl.entity.CustomerRequestForm;
import com.bbnl.entity.User;
import com.bbnl.service.UserExcelService;
import com.bbnl.utility.UserExcelSheetImporter;


@RestController
@CrossOrigin("localhost:8080")
public class UploadExcelRestController {
	
	@Autowired
	private UserExcelService service;
	
	@PostMapping("/upload_excel_data")
	public ResponseEntity<?> uploadExcelData(@RequestParam("file") MultipartFile file) {
		if(UserExcelSheetImporter.checkExcelFormat(file)) {
			
			this.service.saveExcel(file);
			return ResponseEntity.ok(Map.of("message","File is uploaded and save to database."));
			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file format");
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<User>> getAllExcelUsers(){
		return new ResponseEntity<List<User>>(this.service.getAllUsers(), HttpStatus.OK); 
	}
	
	@GetMapping("/getcrf")
	public ResponseEntity<List<CustomerRequestForm>> getAllExcelCustomer(){
		return new ResponseEntity<List<CustomerRequestForm>>(this.service.getAllCustomer(), HttpStatus.OK); 
	}

}
