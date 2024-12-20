package com.cura.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cura.qa.base.TestBase;
import com.cura.qa.pageobjects.Apptmntpage;
import com.cura.qa.pageobjects.HomePage;
import com.cura.qa.pageobjects.LoginPage;
import com.cura.qa.report.ExtentReportUtils;

public class AppointmentPageTest extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	Apptmntpage appointmentPage;

	public AppointmentPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initializeBrowser();
		homePage = new HomePage();
		loginPage = homePage.clickloginBtn();
		appointmentPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHeadingTest() {
		String actualHeading = appointmentPage.validateHeading();
		String expectedHeading = "Make Appointment";
		Assert.assertEquals(expectedHeading, actualHeading);
	}

	@Test(priority = 2)
	public void makeAppointmentTest() {
		String expectedMessage = "Appointment Confirmation";
		String message = appointmentPage.makeAppointment();
		Assert.assertEquals(message, expectedMessage);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}