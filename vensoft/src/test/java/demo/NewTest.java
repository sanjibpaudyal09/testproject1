package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
  String baseUrl="http://newtours.demoaut.com/";
  String path= "C:\\backup\\E drive\\QA materials\\chromedriver.exe";
  public WebDriver driver;
  @BeforeTest
  public void openBrowser() {
	  System.out.println("browser open");
	  System.setProperty("webdriver.chrome.driver",path);
	  driver=new ChromeDriver();
	  driver.get(baseUrl);
	  
  }
  @Test(priority=0)
  public void verifyhomePage() {
	  String expectedTitle = "Welcome: Mercury ";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
  }
  @Test(priority=1)
  public void logIn() {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		String expectedTitle = "Find a Flight: Mercury Tours:";
		 String actualTitle = driver.getTitle();
		 Assert.assertEquals(actualTitle, expectedTitle);
		
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
