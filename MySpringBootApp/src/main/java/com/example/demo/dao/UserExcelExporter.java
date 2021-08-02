package com.example.demo.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Component
public class UserExcelExporter{
	
	@Autowired
	UserServices services;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Employee> listUsers;
    
    public UserExcelExporter(List<Employee> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }
 
    
    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Employee List");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "Emp ID", style);      
        createCell(row, 1, "Emp Name", style);       
        createCell(row, 2, "Emp Role", style);    
        createCell(row, 3, "Emp Add", style);
      
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Employee user : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, user.getEid(), style);
            createCell(row, columnCount++, user.getEname(), style);
            createCell(row, columnCount++, user.getErole(), style);
            createCell(row, columnCount++, user.getEadd(), style);
           
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
    	try {
    	response.setContentType("application/force-download");
		response.setHeader("Content-Transfer-Encoding", "binary");
		//response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=employeesList_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        
         
        List<Employee> listUsers = services.listAll();
         
        UserExcelExporter excelExporter = new UserExcelExporter(listUsers);
        
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        
        workbook.close();
        outputStream.flush();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
       
       
         
    }
	}

