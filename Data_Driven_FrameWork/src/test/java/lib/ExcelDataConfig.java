package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.jetty.util.log.Log;


public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelDataConfig (String excelPath){
		try {
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getData (int sheetNumber, int row, int column) {
		sheet1 = wb.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getRowCount (int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row+1;
		return row;
	}
}
