package vensoft;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseExcleData1 {

	public static void main(String[] args) {
		 String baseUrl="http://newtours.demoaut.com/";
		  String path= "C:\\backup\\E drive\\QA materials\\chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver",path);
		   WebDriver driver= new ChromeDriver();

	}

}
