package com.cura.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.cura.qa.report.ExtentReportUtils;
import com.cura.qa.utils.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite
	public void setExtentReport()
	{
		ExtentReportUtils.setUpReport();
		
	}
	
	public TestBase() {
		
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\sonik\\eclipse-workspace\\CuraHealth\\src\\main\\java\\com\\cura\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public void initializeBrowser()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		/*else if(browserName.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\chromedriver-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}*/
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
			
	}

	@AfterSuite
	public void tearDown()
	{
		ExtentReportUtils.flushReport();
	}



}
