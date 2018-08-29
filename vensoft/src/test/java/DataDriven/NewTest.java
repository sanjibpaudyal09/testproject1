package DataDriven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
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
	// Assert.assertEquals(actualTitle, expectedTitle);
	 Assert.assertTrue(driver.getTitle().contains("Find a Flight:"), "not valid data");
	 System.out.println("login sucessfuly");
  }
  @AfterMethod
  
	  public void backHomePage(){
		  driver.findElement(By.linkText("Home")).click() ;
  }
	  @AfterTest
	  public void terminate() {
		  driver.close();
	  }
	  

  @DataProvider(name="loginData")
  public Object[][] passdata() {
    Object[][] data = new Object[3][2];
      data[0][0]="tutorial";
      data[0][1]="abc";
      data[1][0]="tutorial";
      data[1][1]="tutorial";
      data[2][0]="sanjib";
      data[2][1]="tutorial";
      return data;
    
  }
 

  

}
