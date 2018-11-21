package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataExcel {

	XSSFWorkbook wb;
	Sheet sh;
	String value=null;
	public DataExcel(String path) {
		try{
		File src=new File(path);
		FileInputStream input=new FileInputStream(src);
		//FileOutputStream output = new FileOutputStream(src);
		wb=new XSSFWorkbook(input);
	}catch(Exception e) {
		System.out.println(e.getMessage());
		}
	}
	public String getData(int sheet,int row,int col) {
		sh=wb.getSheetAt(sheet);
		String data=null;
		try {
		data=sh.getRow(row).getCell(col).getStringCellValue();
		}catch(Exception e) {
			
		System.out.println(e.getMessage());
		}
		return data;
		}
	public static void setData(String path,int sheet,int row,int col,String actual) {
		try {
		File file1 =    new File("path");
		FileInputStream inputStream1 = new FileInputStream(file1);
		Workbook w=new XSSFWorkbook(inputStream1);
	     w.getSheetAt(sheet).getRow(row).createCell(col).setCellValue(actual);
		 FileOutputStream output = new FileOutputStream(file1);
			w.write(output);
			}catch(Exception e) {
			}
		}
	public int getRowCount(int sheetIndex) {
		
		return (wb.getSheetAt(sheetIndex).getLastRowNum());
		
	}
	

}
