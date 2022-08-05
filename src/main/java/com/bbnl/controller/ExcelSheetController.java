package com.bbnl.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bbnl.entity.CustomerRequestForm;
import com.bbnl.entity.Demand;
import com.bbnl.entity.User;
import com.bbnl.service.UserExcelService;
import com.bbnl.service.UserService;
import com.bbnl.utility.CustomerRequestFormToExcelSheet;
import com.bbnl.utility.UserExcelSheetExporter;
import com.bbnl.utility.UserExcelSheetImporter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ExcelSheetController {
	
	@Autowired
	UserService service;
	
	@Autowired
	UserExcelService excelService;
	
	@GetMapping("/export_excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String fileName = "users_"+currentDateTime + ".xlsx";
		String headerValue = "attachement; filename=" +fileName;
		
		response.setHeader(headerKey, headerValue);
		
		List<User> list = service.listAllUser();
		
		UserExcelSheetExporter exporter = new UserExcelSheetExporter(list);
		
		exporter.export(response);
		
		
	}
	
	
	

//========================================================================================================
	// For User
	
	@GetMapping("/upload_excel")
	public String showUploadExcelForm() {
		
		return "uploadexcel";
	}


	
	@PostMapping("/upload_excel")
	public ResponseEntity<?> uploadExcelData(@RequestParam("file") MultipartFile file) {
		if(UserExcelSheetImporter.checkExcelFormat(file)) {
			
			excelService.saveExcel(file);
			return ResponseEntity.ok(Map.of("message","File is uploaded and save to database."));
			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file format");
	}
	


	
	@GetMapping("/list")
	public List<User> getAllUser(){
		return excelService.getAllUsers();
	}
	
	
//============================================================================================================================================================
	// For Customer
	
	@GetMapping("/export_crf_excel")
	public void crfDataExcelExporter(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd_hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		String fileName = "crf_"+currentDateTime + ".xlsx";
		String headerValue = "attachement; filename=" +fileName;
	
		response.setHeader(headerKey, headerValue);
		
		List<CustomerRequestForm> list = excelService.getAllCustomer();
		List<Demand> list1 = excelService.getAllDemand();
		
		
		
		CustomerRequestFormToExcelSheet exporter = new CustomerRequestFormToExcelSheet(list,list1);
		exporter.exportCRFData(response);
		
		
	}
	
	
	

	

}
