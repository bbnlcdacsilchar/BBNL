package com.bbnl.utility;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.bbnl.entity.CustomerRequestForm;
import com.bbnl.entity.Demand;

@Component
public class CustomerRequestFormToExcelSheet {

	private XSSFWorkbook workbook;

	private XSSFSheet sheet;

	private List<CustomerRequestForm> listUsers;

	private List<Demand> list;

	public CustomerRequestFormToExcelSheet() {

	}

	public CustomerRequestFormToExcelSheet(List<CustomerRequestForm> listUsers, List<Demand> list) {
		this.listUsers = listUsers;
		this.list = list;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("CRF");

	}

	private void writeHeaderRow() {
		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.getIndex());  
//        style.setFillPattern(FillPatternType.BIG_SPOTS);

		Cell cell = row.createCell(0);
		cell.setCellValue("CRF_ID");
		sheet.autoSizeColumn(0);
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("ApplicantName");
		sheet.autoSizeColumn(1);
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("ApplicantAddress");
		sheet.autoSizeColumn(2);
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("ApplicantPan");
		sheet.autoSizeColumn(3);
		cell.setCellStyle(style);

		cell = row.createCell(4);
		cell.setCellValue("BandwidthRequired");
		sheet.autoSizeColumn(4);
		cell.setCellStyle(style);

		cell = row.createCell(5);
		cell.setCellValue("Application_date");
		sheet.autoSizeColumn(5);
		cell.setCellStyle(style);

		cell = row.createCell(6);
		cell.setCellValue("PortCapacityRequired");
		sheet.autoSizeColumn(6);
		cell.setCellStyle(style);

		cell = row.createCell(7);
		cell.setCellValue("LegalStatus");
		sheet.autoSizeColumn(7);
		cell.setCellStyle(style);

		cell = row.createCell(8);
		cell.setCellValue("BillingAddress");
		sheet.autoSizeColumn(8);
		cell.setCellStyle(style);

		cell = row.createCell(9);
		cell.setCellValue("GramPanchayat");
		sheet.autoSizeColumn(9);
		cell.setCellStyle(style);

		cell = row.createCell(10);
		cell.setCellValue("GpContactName");
		sheet.autoSizeColumn(10);
		cell.setCellStyle(style);

		cell = row.createCell(11);
		cell.setCellValue("GpContactEmail");
		sheet.autoSizeColumn(11);
		cell.setCellStyle(style);

		cell = row.createCell(12);
		cell.setCellValue("GpContactMobile");
		sheet.autoSizeColumn(12);
		cell.setCellStyle(style);

		cell = row.createCell(13);
		cell.setCellValue("GpContactAddress");
		sheet.autoSizeColumn(13);
		cell.setCellStyle(style);

		cell = row.createCell(14);
		cell.setCellValue("GpContactDesignation");
		sheet.autoSizeColumn(14);
		cell.setCellStyle(style);

		cell = row.createCell(15);
		cell.setCellValue("Block");
		sheet.autoSizeColumn(15);
		cell.setCellStyle(style);

		cell = row.createCell(16);
		cell.setCellValue("BlockContactName");
		sheet.autoSizeColumn(16);
		cell.setCellStyle(style);

		cell = row.createCell(17);
		cell.setCellValue("BlockContactEmail");
		sheet.autoSizeColumn(17);
		cell.setCellStyle(style);

		cell = row.createCell(18);
		cell.setCellValue("BlockContactMobile");
		sheet.autoSizeColumn(18);
		cell.setCellStyle(style);

		cell = row.createCell(19);
		cell.setCellValue("BlockContactAddress");
		sheet.autoSizeColumn(19);
		cell.setCellStyle(style);

		cell = row.createCell(20);
		cell.setCellValue("BlockContactDesignation");
		sheet.autoSizeColumn(20);
		cell.setCellStyle(style);

		cell = row.createCell(21);
		cell.setCellValue("ContactName");
		sheet.autoSizeColumn(21);
		cell.setCellStyle(style);

		cell = row.createCell(22);
		cell.setCellValue("ContactMobile");
		sheet.autoSizeColumn(22);
		cell.setCellStyle(style);

		cell = row.createCell(23);
		cell.setCellValue("ContactAddress");
		sheet.autoSizeColumn(23);
		cell.setCellStyle(style);

		cell = row.createCell(24);
		cell.setCellValue("ContactEmail");
		sheet.autoSizeColumn(24);
		cell.setCellStyle(style);

		cell = row.createCell(25);
		cell.setCellValue("State");
		sheet.autoSizeColumn(25);
		cell.setCellStyle(style);

		cell = row.createCell(26);
		cell.setCellValue("District");
		sheet.autoSizeColumn(26);
		cell.setCellStyle(style);
		
		cell = row.createCell(27);
		cell.setCellValue("General Information");
		sheet.autoSizeColumn(27);
		cell.setCellStyle(style);
		
/*

		cell = row.createCell(27);
		cell.setCellValue("DemandId");
		sheet.autoSizeColumn(27);
		cell.setCellStyle(style);

		cell = row.createCell(28);
		cell.setCellValue("DemandUserId");
		sheet.autoSizeColumn(28);
		cell.setCellStyle(style);

		cell = row.createCell(29);
		cell.setCellValue("DemandDate");
		sheet.autoSizeColumn(29);
		cell.setCellStyle(style);

		cell = row.createCell(30);
		cell.setCellValue("Status");
		sheet.autoSizeColumn(30);
		cell.setCellStyle(style);

		cell = row.createCell(31);
		cell.setCellValue("GpId");
		sheet.autoSizeColumn(31);
		cell.setCellStyle(style);

		cell = row.createCell(32);
		cell.setCellValue("BlockId");
		sheet.autoSizeColumn(32);
		cell.setCellStyle(style);

		cell = row.createCell(33);
		cell.setCellValue("DistrictId");
		sheet.autoSizeColumn(33);
		cell.setCellStyle(style);

		cell = row.createCell(34);
		cell.setCellValue("StateId");
		sheet.autoSizeColumn(34);
		cell.setCellStyle(style);

		cell = row.createCell(35);
		cell.setCellValue("DemandType");
		sheet.autoSizeColumn(35);
		cell.setCellStyle(style);

		cell = row.createCell(36);
		cell.setCellValue("BulkRequesId");
		sheet.autoSizeColumn(36);
		cell.setCellStyle(style);
		
*/

	}

	

	
	@SuppressWarnings("deprecation")
	private void writeDataRow() {

		int rowCount = 1;

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.BIG_SPOTS);
        style.setBorderBottom(BorderStyle.HAIR);
        style.setShrinkToFit(true);
        

		for (CustomerRequestForm user : listUsers) {

			Row row = sheet.createRow(rowCount++);

			Cell cell = row.createCell(0);
			cell.setCellValue(user.getCrfId());
			sheet.autoSizeColumn(0);
			cell.setCellStyle(style);
			

			cell = row.createCell(1);
			cell.setCellValue(user.getApplicantName());
			sheet.autoSizeColumn(1);
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue(user.getApplicantAddress());
			sheet.autoSizeColumn(2);
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue(user.getApplicantPan());
			sheet.autoSizeColumn(3);
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue(user.getBandwidthRequired());
			sheet.autoSizeColumn(4);
			cell.setCellStyle(style);

			cell = row.createCell(5);
			cell.setCellValue(user.getApplication_date().toGMTString());
			sheet.autoSizeColumn(5);
			cell.setCellStyle(style);

			cell = row.createCell(6);
			cell.setCellValue(user.getPortCapacityRequired());
			sheet.autoSizeColumn(6);
			cell.setCellStyle(style);

			cell = row.createCell(7);
			cell.setCellValue(user.getLegalStatus());
			sheet.autoSizeColumn(7);
			cell.setCellStyle(style);

			cell = row.createCell(8);
			cell.setCellValue(user.getBillingAddress());
			sheet.autoSizeColumn(8);
			cell.setCellStyle(style);

			cell = row.createCell(9);
			cell.setCellValue(user.getGp());
			sheet.autoSizeColumn(9);
			cell.setCellStyle(style);

			cell = row.createCell(10);
			cell.setCellValue(user.getGpContactName());
			sheet.autoSizeColumn(10);
			cell.setCellStyle(style);

			cell = row.createCell(11);
			cell.setCellValue(user.getGpContactEmail());
			sheet.autoSizeColumn(11);
			cell.setCellStyle(style);

			cell = row.createCell(12);
			cell.setCellValue(user.getGpContactMobile());
			sheet.autoSizeColumn(12);
			cell.setCellStyle(style);

			cell = row.createCell(13);
			cell.setCellValue(user.getGpContactAddress());
			sheet.autoSizeColumn(13);
			cell.setCellStyle(style);

			cell = row.createCell(14);
			cell.setCellValue(user.getGpContactDesignation());
			sheet.autoSizeColumn(14);
			cell.setCellStyle(style);

			cell = row.createCell(15);
			cell.setCellValue(user.getBlock());
			sheet.autoSizeColumn(15);
			cell.setCellStyle(style);

			cell = row.createCell(16);
			cell.setCellValue(user.getBlockContactName());
			sheet.autoSizeColumn(16);
			cell.setCellStyle(style);

			cell = row.createCell(17);
			cell.setCellValue(user.getBlockContactEmail());
			sheet.autoSizeColumn(17);
			cell.setCellStyle(style);

			cell = row.createCell(18);
			cell.setCellValue(user.getBlockContactMobile());
			sheet.autoSizeColumn(18);
			cell.setCellStyle(style);

			cell = row.createCell(19);
			cell.setCellValue(user.getBlockContactAddress());
			sheet.autoSizeColumn(19);
			cell.setCellStyle(style);

			cell = row.createCell(20);
			cell.setCellValue(user.getBlockContactDesignation());
			sheet.autoSizeColumn(20);
			cell.setCellStyle(style);

			cell = row.createCell(21);
			cell.setCellValue(user.getContactName());
			sheet.autoSizeColumn(21);
			cell.setCellStyle(style);

			cell = row.createCell(22);
			cell.setCellValue(user.getContactMobile());
			sheet.autoSizeColumn(22);
			cell.setCellStyle(style);

			cell = row.createCell(23);
			cell.setCellValue(user.getContactAddress());
			sheet.autoSizeColumn(23);
			cell.setCellStyle(style);

			cell = row.createCell(24);
			cell.setCellValue(user.getContactEmail());
			sheet.autoSizeColumn(24);
			cell.setCellStyle(style);

			cell = row.createCell(25);
			cell.setCellValue(user.getState());
			sheet.autoSizeColumn(25);
			cell.setCellStyle(style);

			cell = row.createCell(26);
			cell.setCellValue(user.getDistrict());
			sheet.autoSizeColumn(26);
			cell.setCellStyle(style);
			
			cell = row.createCell(27);
			cell.setCellValue(user.getGeneralInformation());
			sheet.autoSizeColumn(27);
			cell.setCellStyle(style);

			// ========================
/*
			for (Demand demand : list) {

				cell = row.createCell(27);
				cell.setCellValue(demand.getDemandId());
				sheet.autoSizeColumn(27);
				cell.setCellStyle(style);

//				cell = row.createCell(28);
//				cell.setCellValue(demand.getDemandUserId());
//				sheet.autoSizeColumn(28);
//				cell.setCellStyle(style);
//
//				cell = row.createCell(29);
//				cell.setCellValue(demand.getDemandDate().toGMTString());
//				sheet.autoSizeColumn(29);
//				cell.setCellStyle(style);
//
//				cell = row.createCell(30);
//				cell.setCellValue(demand.getStatus());
//				sheet.autoSizeColumn(30);
//				cell.setCellStyle(style);

				cell = row.createCell(28);
				cell.setCellValue(demand.getGp().toString());
				sheet.autoSizeColumn(28);
				cell.setCellStyle(style);

				cell = row.createCell(29);
				cell.setCellValue(demand.getBlock().toString());				
				sheet.autoSizeColumn(29);
				cell.setCellStyle(style);

				cell = row.createCell(30);
				cell.setCellValue(demand.getDistrict().toString());
				sheet.autoSizeColumn(30);
				cell.setCellStyle(style);

				cell = row.createCell(31);
				cell.setCellValue(demand.getState().toString());
				sheet.autoSizeColumn(31);
				cell.setCellStyle(style);

//				cell = row.createCell(35);
//				cell.setCellValue(demand.getDemandType());
//				sheet.autoSizeColumn(35);
//				cell.setCellStyle(style);
//
//				cell = row.createCell(36);
//				cell.setCellValue(demand.getBulkRequestId());
//				sheet.autoSizeColumn(36);
//				cell.setCellStyle(style);

				rowCount++;

			}
*/
		}

	}

	public void exportCRFData(HttpServletResponse response) throws IOException {
		writeHeaderRow();
		writeDataRow();
		

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}

	public void exportEmptyCRFWithHeader(HttpServletResponse response) throws IOException {
		writeHeaderRow();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}

}
