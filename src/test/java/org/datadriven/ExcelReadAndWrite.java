package org.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadAndWrite {
	
	public static void main(String[] args) throws IOException  {
		
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace"
				+ "\\LanuageDetails\\MavenProject\\src\\test\\resources\\data.xlsx");
		
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(inputStream);
		
		//Access the sheet
		Sheet sheet = workbook.getSheet("Sheet3");
		
		//Create a sheet
		Sheet createSheet = workbook.createSheet("Sheet6");
		
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		
		for(int i=0;i<numberOfRows;i++) {
			Row row = sheet.getRow(i);
			int numberOfCells = row.getPhysicalNumberOfCells();
			Row createRow = createSheet.createRow(i);
			
			for(int j=0;j<numberOfCells;j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();// STRING  NUMERIC
				Cell createCell = createRow.createCell(j);
				switch (cellType) {
				case STRING:
					String cellValue = cell.getStringCellValue();
					createCell.setCellValue(cellValue);
					break;
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
						String format = dateFormat.format(dateCellValue);
						createCell.setCellValue(format);
					}else {
					double numericCellValue = cell.getNumericCellValue();
					long value = (long) numericCellValue;
					createCell.setCellValue(value);
					break;
					}
				default:
					break;				
				}			
			}		
		}	
		
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		
	}
}









