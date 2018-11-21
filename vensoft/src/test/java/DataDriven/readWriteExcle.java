package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class readWriteExcle {
	String baseUrl="http://newtours.demoaut.com/";
	String path= "C:\\backup\\E drive\\QA materials\\chromedriver.exe";
	 public WebDriver driver;
	 String expectedTitle;
	 String actualTitle;
	 int r=1;
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test open browser");
		  System.setProperty("webdriver.chrome.driver",path);
		  driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.get(baseUrl);	
		  driver.manage().window().maximize();
		
	  }
	  @BeforeMethod
	  public void verifyHomePage() {
		  System.out.println("open browser");
		  String expectedTitle = "Welcome: Mercury Tours";
	      String actualTitle = driver.getTitle();
	      Assert.assertEquals(actualTitle, expectedTitle);
		  
	  }
  @Test(dataProvider = "loginData")
  public void login(String userName , String password) throws InterruptedException {
  
  System.out.println("login");
  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(userName);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("login")).click();
	Thread.sleep(2000);
	String expectedTitle = "Find a Flight: Mercury Tours:";
	 String actualTitle = driver.getTitle();
	 
	// DataExcel.setData("C:\\Users\\sanjib\\Desktop\\excel1.xlsx",0,r,3,actualTitle) ;
	File file =    new File("C:\\Users\\sanjib\\Desktop\\excel1.xlsx");
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
		
		Workbook wb=new XSSFWorkbook(inputStream);
	wb.getSheetAt(0).getRow(r).createCell(3).setCellValue(actualTitle);

	if(expectedTitle.equals(actualTitle)) {
		
		wb.getSheetAt(0).getRow(r).createCell(4).setCellValue("pass");
	}else
		wb.getSheetAt(0).getRow(r).createCell(4).setCellValue("fail");
		
	FileOutputStream output = new FileOutputStream(file);
	wb.write(output);
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	r=r+1;
	// Assert.assertEquals(actualTitle, expectedTitle);
	 Assert.assertTrue(driver.getTitle().contains("Find a Flight:"), "not valid data");
	 System.out.println("login sucessfuly");
  }
  
  @AfterMethod
  
	  public void backHomePage() throws IOException {
	 
		  driver.findElement(By.linkText("Home")).click() ;
  }
	  @AfterTest
	  public void terminate() {
		  driver.close();
	  }
	  

  @DataProvider(name="loginData")
  public Object[][] passdata() {
	  DataExcel de=new DataExcel("C:\\Users\\sanjib\\Desktop\\excel1.xlsx");
	  int rows=de.getRowCount(0);
    Object[][] data = new Object[rows][2];
    
    for(int i=1;i<rows;i++) {
      data[i][0]=de.getData(0, i+1, 0);
      data[i][1]=de.getData(0, i+1, 1);
      
      
   
    }
	return data;
  }
 

  

  
}
