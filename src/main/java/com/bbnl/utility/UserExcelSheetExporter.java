package com.bbnl.utility;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.stereotype.Component;
import com.bbnl.entity.User;



@Component
public class UserExcelSheetExporter {
	
	

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<User> listUsers;
	
	public UserExcelSheetExporter() {
		
	}

	public UserExcelSheetExporter(List<User> listUsers) {
		this.listUsers = listUsers;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Users");
		
	}
	
	

	private void writeHeaderRow() {
		
		
		
		Row row = sheet.createRow(0);
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.BIG_SPOTS);
		style.setFont(font);
		
		
		Cell cell = row.createCell(0);
		cell.setCellValue("User ID");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(0);
		
		
		

		cell = row.createCell(1);
		cell.setCellValue("First Name");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(1);
		


		cell = row.createCell(2);
		cell.setCellValue("Middle Name");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(2);


		cell = row.createCell(3);
		cell.setCellValue("Last Name");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(3);


		cell = row.createCell(4);
		cell.setCellValue("Password");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(4);


		cell = row.createCell(5);
		cell.setCellValue("Email");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(5);


		cell = row.createCell(6);
		cell.setCellValue("Mobile No");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(6);


		cell = row.createCell(7);
		cell.setCellValue("City");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(7);


		cell = row.createCell(8);
		cell.setCellValue("Address");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(8);


		cell = row.createCell(9);
		cell.setCellValue("Security Quesion");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(9);


		cell = row.createCell(10);
		cell.setCellValue("SecurityAnswer");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(10);


		cell = row.createCell(11);
		cell.setCellValue("Status");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(11);


		cell = row.createCell(12);
		cell.setCellValue("Role");
		cell.setCellStyle(style);
		sheet.autoSizeColumn(12);


	}

	private void writeDataRow() {

		int rowCount = 1;
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
		style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
        style.setFillPattern(FillPatternType.BIG_SPOTS);
        style.setBorderBottom(BorderStyle.HAIR);
        style.setShrinkToFit(true);
       

		for (User user : listUsers) {

			Row row = sheet.createRow(rowCount);

			Cell cell = row.createCell(0);
			cell.setCellValue(user.getUserId());
			sheet.autoSizeColumn(0);
			cell.setCellStyle(style);
			
			cell = row.createCell(1);
			cell.setCellValue(user.getFirstName());
			sheet.autoSizeColumn(1);
			cell.setCellStyle(style);
			
			cell = row.createCell(2);
			cell.setCellValue(user.getMiddleName());
			sheet.autoSizeColumn(2);
			cell.setCellStyle(style);
			
			cell = row.createCell(3);
			cell.setCellValue(user.getLastName());
			sheet.autoSizeColumn(3);
			cell.setCellStyle(style);
			
			cell = row.createCell(4);
			cell.setCellValue(user.getPassword());
			sheet.autoSizeColumn(4);
			cell.setCellStyle(style);
			
			cell = row.createCell(5);
			cell.setCellValue(user.getEmail());
			sheet.autoSizeColumn(5);
			cell.setCellStyle(style);
			
			cell = row.createCell(6);
			cell.setCellValue(user.getMobileNumber());
			sheet.autoSizeColumn(6);
			cell.setCellStyle(style);
			
			cell = row.createCell(7);
			cell.setCellValue(user.getCity());
			sheet.autoSizeColumn(7);
			cell.setCellStyle(style);
			
			cell = row.createCell(8);
			cell.setCellValue(user.getAddress());
			sheet.autoSizeColumn(8);
			cell.setCellStyle(style);
			
			cell = row.createCell(9);
			cell.setCellValue(user.getSecQuestion());
			sheet.autoSizeColumn(9);
			cell.setCellStyle(style);
			
			cell = row.createCell(10);
			cell.setCellValue(user.getSecAnswer());
			sheet.autoSizeColumn(10);
			cell.setCellStyle(style);
			
			cell = row.createCell(11);
			cell.setCellValue(user.isStatus());
			sheet.autoSizeColumn(11);
			cell.setCellStyle(style);
			
			cell = row.createCell(12);
			cell.setCellValue(user.getRole().toString());
			sheet.autoSizeColumn(12);
			cell.setCellStyle(style);
			
			rowCount++;
			
		}

	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderRow();
		writeDataRow();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}
	
	public void exportEmptyWithHeader(HttpServletResponse response) throws IOException {
		writeHeaderRow();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}

}