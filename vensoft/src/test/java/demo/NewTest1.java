package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest1 {
	String baseUrl="http://newtours.demoaut.com/";
	String path= "C:\\backup\\E drive\\QA materials\\chromedriver.exe";
	 public WebDriver driver;
	 String expectedTitle;
	 String actualTitle;
	 @BeforeTest
	  public void beforeTest() {
		  System.out.println("before test open browser");
		  System.setProperty("webdriver.chrome.driver",path);
		  driver=new ChromeDriver();
		  driver.get(baseUrl);
	  }
	 

  @BeforeMethod
  public void verifyHomePage() {
	  System.out.println("open browser");
	  String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
	  
  }
  @Test(priority=0)
  public void registerForNew() {
	  System.out.println("register");
	  driver.findElement(By.linkText("REGISTER")).click(); 
	  String expectedTitle="Register: Mercury Tours";
		 String actualTitle=driver.getTitle();
		 Assert.assertEquals(actualTitle, expectedTitle);
  }
  @Test(priority=1)
  
	  public void logIn() {
	  System.out.println("login");
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("tutorial");
			driver.findElement(By.name("password")).sendKeys("tutoria");
			driver.findElement(By.name("login")).click();
			String expectedTitle = "Find a Flight: Mercury Tours:";
			 String actualTitle = driver.getTitle();
			 Assert.assertEquals(actualTitle, expectedTitle);
			
	  }
	  
  

  @AfterMethod
  public void backHomePage(){
	  driver.findElement(By.linkText("Home")).click() ;
  }

 

  @AfterTest
  public void terminateBrowser() {
	  driver.close();
  }

}
