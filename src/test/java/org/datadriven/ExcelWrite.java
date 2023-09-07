package org.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\LanuageDetails"
				+ "\\MavenProject\\src\\test\\resources\\data.xlsx");
		
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(inputStream);
		
		//Sheet createSheet = workbook.createSheet("Sheet4");
		Sheet sheet = workbook.getSheet("Sheet4");
		
		//Row createRow = sheet.createRow(1);
		Row row = sheet.getRow(1);
		Cell createCell = row.createCell(1);
		
		createCell.setCellValue("Greens");
		
		FileOutputStream outputStream = new FileOutputStream(file);
		
		workbook.write(outputStream);
		
		
	}

}
