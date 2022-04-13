package CsvFileReading;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class CsvFile {

	String CsvPath = "C:\\Users\\user\\eclipse-workspace\\CsvFileReading\\CsvData\\CsvFile1.csv";
	WebDriver driver;
	
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\eclipse-workspace\\LaunchChromeBrowser\\SeleniumBrowserJars\\chromedriver.exe" );
		
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");
	}
	
	
	
	@Test
     public void TestingBlog() throws IOException, InterruptedException {
		CSVReader reader = new CSVReader(new FileReader(CsvPath));
		String[] csvCell;
		while((csvCell=reader. readNext())!= null) {
			String FName = csvCell[0];
			String LName = csvCell[1];
			String Email = csvCell[2];
			String MPhone = csvCell[3];
			String ComName = csvCell[4];
			
			driver.findElement(By.name("FirstName")).sendKeys(FName);
			driver.findElement(By.name("LastName")).sendKeys(LName);
			driver.findElement(By.name("EmailID")).sendKeys(Email);
			driver.findElement(By.name("MobNo")).sendKeys(MPhone);
			driver.findElement(By.name("Company")).sendKeys(ComName);
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"post-body-8228718889842861683\"]/div[1]/form/input[6]")).click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();	
			
		}
		reader.close();

	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	



}
