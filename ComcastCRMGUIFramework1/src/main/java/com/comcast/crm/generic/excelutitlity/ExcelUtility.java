package com.comcast.crm.generic.excelutitlity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readDataFromExcel(String sheetName,int rowNum, int cellNum) throws Throwable{
		
		Workbook wrk = WorkbookFactory.create( new FileInputStream("./configureAppData/TSdata.xlsx") );
		
		Sheet s = wrk.getSheet(sheetName);
		
		Row r = s.getRow(rowNum);
		
		Cell cel = r.getCell(cellNum);
		
		wrk.close();
		
		return cel.getStringCellValue();
	}
	
	public int getRowCount(String sheetName) throws Throwable {
		Workbook wrk = WorkbookFactory.create(new FileInputStream("./configureAppData/TSdata.xlsx"));
		wrk.close();
		return wrk.getSheet(sheetName).getLastRowNum();
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum, int cellNum, String inputData) throws Throwable{
		Workbook wrk = WorkbookFactory.create( new FileInputStream("./configureAppData/TSdata.xlsx") );
		
		Sheet s = wrk.getSheet(sheetName);
		
		Row r = s.getRow(rowNum);
		
		r.createCell(cellNum);
		
		wrk.write(new FileOutputStream("./configureAppData/TSdata.xlsx"));
		
		wrk.close();
	}
}
