package crossBrowser;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class NewTest {
	WebDriver driver;
 @Test
 @Parameters("browser")
  public void verifyHome(String browserName ) {
	  if(browserName.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver", "C:\\backup\\E drive\\QA materials\\geckodriver.exe");
		  driver=new FirefoxDriver();
		  System.out.println("running firefox");
		  
	  }
	  else if(browserName.equalsIgnoreCase("chrome")){
		
		  System.setProperty("webdriver.chrome.driver", "C:\\backup\\E drive\\QA materials\\chromedriver.exe");
		  driver=new ChromeDriver();
		  System.out.println("running chrome");
	 }
	 
	  driver.manage().window().maximize();
	  driver.get("https://www.freecrm.com");
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("http://newtours.demoaut.com/");
	  System.out.println( driver.getTitle());
	 
  }
  

}
