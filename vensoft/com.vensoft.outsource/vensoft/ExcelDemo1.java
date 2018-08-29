package vensoft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class ExcelDemo1 {

	public static void main(String[] args) throws IOException {
		File file =    new File("C:\\Users\\sanjib\\Desktop\\readWrite.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb=new XSSFWorkbook(inputStream);
		 //Read sheet inside the workbook by its name
		Sheet Sheet = wb.getSheet("Sheet1");
		
		//Find number of rows in excel file
		int rowCount = Sheet.getLastRowNum();
		
		 //Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount+1; i++) {

	        Row row = Sheet.getRow(i);
	        
	      //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console

	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }
	    	Sheet.getRow(0).createCell(3).setCellValue("dallas");
			
			FileOutputStream output = new FileOutputStream(file);
			wb.write(output);
	        System.out.println();
		}
	}
}


