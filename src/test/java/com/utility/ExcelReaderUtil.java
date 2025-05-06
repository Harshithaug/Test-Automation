package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtil {
	
	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		File xlsxfile = new File(System.getProperty("user.dir")+"\\testData\\LoginData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(xlsxfile);
		XSSFSheet xsssheet=wb.getSheet("LoginTestData");
		
	}

}
