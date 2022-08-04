package com.bbnl.utility;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bbnl.entity.CustomerRequestForm;
import com.bbnl.entity.User;

@Component
public class UserExcelSheetImporter {
	
	
	//Check that file is excel type or not
	public static boolean checkExcelFormat(MultipartFile file) {
		
		String contentType = file.getContentType();
		
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}else {
			return false;
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static List<CustomerRequestForm> convertExcelToListOfUsers(InputStream stream){
		
		List<CustomerRequestForm> list = new ArrayList<>();
		
		try {
			
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(stream);
			
			XSSFSheet sheet = workbook.getSheet("crf");
			
			int rowNumber =0;
			Iterator<Row> iterator = sheet.iterator();			
			
			while(iterator.hasNext()) {
				Row row = iterator.next();
				
				if(rowNumber==0) {
					rowNumber++;
					continue;
				}
				
				Iterator<Cell> cells = row.iterator();
				
				int cid = 0;
				
				CustomerRequestForm user = new CustomerRequestForm();
				
				while(cells.hasNext()) {
					Cell cell = cells.next();
					
					switch(cid) {
					case 0:
						user.setCrfId( (int) cell.getNumericCellValue());
						break;
					case 1:
						user.setApplicantName(cell.getStringCellValue());
						break;
					case 2:
						user.setApplicantAddress(cell.getStringCellValue());
						break;
					case 3:
						user.setApplicantPan(cell.getStringCellValue());
						break;
					case 4:
						user.setBandwidthRequired(cell.getNumericCellValue());
						break;
				
					case 5:
						user.setApplication_date((Date)cell.getDateCellValue());
						break;
					case 6:
						user.setPortCapacityRequired((int) cell.getNumericCellValue());
						break;
					case 7:
						user.setLegalStatus((int) cell.getNumericCellValue());
						break;
					case 8:						
						user.setBillingAddress(cell.getStringCellValue());
						break;
					case 9:						
						user.setGp(cell.getStringCellValue());
						break;
					case 10:						
						user.setGpContactName(cell.getStringCellValue());
						break;
					case 11:												
						user.setGpContactEmail(cell.getStringCellValue());
						break;
					case 12:						
						user.setGpContactMobile(cell.getStringCellValue());
						break;
					case 13:
						user.setGpContactAddress(cell.getStringCellValue());
						break;
					case 14:
						user.setGpContactDesignation(cell.getStringCellValue());
						break;
					case 15:
						user.setBlock(cell.getStringCellValue());
						break;
					case 16:
						user.setBlockContactName(cell.getStringCellValue());
						break;
					case 17:
						user.setBlockContactEmail(cell.getStringCellValue());
						break;
					case 18:
						user.setBlockContactMobile(cell.getStringCellValue());
						break;
					case 19:
						user.setBlockContactAddress(cell.getStringCellValue());
						break;
					case 20:
						user.setBlockContactDesignation(cell.getStringCellValue());
						break;
					case 21:
						user.setContactName(cell.getStringCellValue());
						break;
					case 22:
						user.setContactMobile(cell.getStringCellValue());
						break;
					case 23:
						user.setContactAddress(cell.getStringCellValue());
						break;
					case 24:
						user.setContactEmail(cell.getStringCellValue());
						break;
					case 25:
						user.setState(cell.getStringCellValue());
						break;
					case 26:
						user.setDistrict(cell.getStringCellValue());
						break;
					case 27:
						user.setGeneralInformation(cell.getStringCellValue());
						break;
										
					}
					cid++;
				}
				
				list.add(user);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
