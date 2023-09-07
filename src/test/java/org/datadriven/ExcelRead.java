package org.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\LanuageDetails"
				+ "\\MavenProject\\src\\test\\resources\\data.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(stream);	
		
		Sheet sheet = workbook.getSheet("Sheet3");

		int numberOfRows = sheet.getPhysicalNumberOfRows();
		
		for(int r=0;r<numberOfRows;r++) {
			Row row = sheet.getRow(r);
			int numberOfCells = row.getPhysicalNumberOfCells();
			for(int c=0;c<numberOfCells;c++) {
				Cell cell = row.getCell(c);
				
				DataFormatter dataFormatter = new DataFormatter();
				String formatCellValue = dataFormatter.formatCellValue(cell);
				
				
				CellType cellType = cell.getCellType();// STRING  NUMERIC
				String value="";
				switch (cellType) {
				case STRING:
					String cellValue = cell.getStringCellValue();
					System.out.println(cellValue);
					break;
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
						String format = dateFormat.format(dateCellValue);
						System.out.println(format);
					}else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					value = Long.toString(l);
					break;
					}
				case BOOLEAN:
					boolean booleanCellValue = cell.getBooleanCellValue();
					value = Boolean.toString(booleanCellValue);
				default:
					break;
					
				}
				
			}
		}
		
	}
}
