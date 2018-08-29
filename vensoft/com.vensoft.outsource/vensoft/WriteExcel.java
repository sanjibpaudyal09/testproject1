package vensoft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class WriteExcel {

	public static void main(String[] args) {
		
		try {
			
		
		File file =    new File("C:\\Users\\sanjib\\Desktop\\excel.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb=new XSSFWorkbook(inputStream);
		 //Read sheet inside the workbook by its name
		//Sheet sheet = wb.getSheet("Sheet1");
		 //Read sheet inside the workbook by its index
		//Sheet sheet = wb.getSheetAt(1);
		//sheet.getRow(2).createCell(3).setCellValue("austin");
		Sheet sheet = wb.createSheet("Sheet1");
		// if you create new sheet
		sheet.createRow(0).createCell(3).setCellValue("dallas");
		
		FileOutputStream output = new FileOutputStream(file);
		wb.write(output);
		
	
		
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
