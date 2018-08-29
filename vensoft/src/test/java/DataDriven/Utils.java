package DataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
	 String baseUrl="http://newtours.demoaut.com/";
 String path= "C:\\backup\\E drive\\QA materials\\chromedriver.exe";
	 public  WebDriver driver;
	 String expectedTitle;
	 String actualTitle;
	public  void before() {
		System.out.println("before test open browser");
		  System.setProperty("webdriver.chrome.driver",path);
		  driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.get(baseUrl);	
		  driver.manage().window().maximize();
	  }
}
