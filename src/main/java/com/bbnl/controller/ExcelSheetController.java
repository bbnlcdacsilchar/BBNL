package com.bbnl.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	// For CRF
	
	@GetMapping("/upload_excel")
	public String showUploadExcelForm() {
		
		return "uploadexcel";
	}


	
	@PostMapping("/upload_excel")
	public String/* ResponseEntity<?> */uploadExcelData(@RequestParam("file") MultipartFile file) {
		if(UserExcelSheetImporter.checkExcelFormat(file)) {
			
			excelService.saveExcel(file);
			return "redirect:/upload_excel?success"; 
			
		}
		return "redirect:/upload_excel?error";
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
	
//=======================================================================================================================
	
	//For Download the demo Excel file with drop-down
	
	@GetMapping("/download_file")
	public void downloadFile(HttpServletResponse response) throws IOException {
		
		File file = new File("files/crf.xlsx");
		
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		
		String headerValue = "attachement; filename=" +file.getName();
	
		response.setHeader(headerKey, headerValue);
		
		ServletOutputStream outputStream = response.getOutputStream();
		
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		
		byte[] buffer = new byte[8192]; //8KB
		
		int bytesRead = -1;
		
		while((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer,0,bytesRead);
		}
		inputStream.close();
		outputStream.close();
		
	}
	
}
