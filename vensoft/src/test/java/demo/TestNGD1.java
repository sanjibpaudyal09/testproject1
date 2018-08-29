package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGD1 {;
String baseUrl="http://newtours.demoaut.com/";
	
	
	public WebDriver driver;
  
  
  @Test
  public void verifyHomePage() {
	     System.out.println("launching firefox browser"); 
	 	System.setProperty("webdriver.chrome.driver", "C:\\backup\\E drive\\QA materials\\chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.get(baseUrl);
	      String expectedTitle = "Welcome: Mercury Tours";
	      String actualTitle = driver.getTitle();
	      Assert.assertEquals(actualTitle, expectedTitle);
	     // driver.close();
	  }
	  
  }

  


