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

public class LoginTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	Apptmntpage appointmentPage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initializeBrowser();
		homePage = new HomePage();
		loginPage = homePage.clickloginBtn();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateTitle();
		Assert.assertEquals(title, "CURA Healthcare Service");
	}

	@Test(priority = 2)
	public void loginPageHeadingTest() {
		String heading = loginPage.validateHeading();
		Assert.assertEquals(heading, "Login");
	}

	@Test(priority = 3)
	public void validateLoginTest() {

		String expectedUrl = "https://katalon-demo-cura.herokuapp.com/#appointment";
		appointmentPage= loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		String pageUrl = driver.getCurrentUrl();
		Assert.assertEquals(pageUrl, expectedUrl);
		System.out.println("Login Successful");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
