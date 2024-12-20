package com.cura.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cura.qa.base.TestBase;
import com.cura.qa.pageobjects.HomePage;
import com.cura.qa.pageobjects.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
	initializeBrowser();
	homePage= new HomePage();
	}
	
	@Test
	public void homePageTitleTest()
	{
		String actualTitle= homePage.verifyHomePageTitle();
		Assert.assertEquals(actualTitle, "CURA Healthcare Service");
	}
	
	@Test
	public void homePageHeading1Test()
	{
		String actualHeading1= homePage.verifyHeading();
		Assert.assertEquals(actualHeading1, "CURA Healthcare Service");
	}
	
	@Test
	public void homePageHeading2Test()
	{
		String actualHeading2= homePage.verifyHeading2();
		Assert.assertEquals(actualHeading2, "We Care About Your Health");
	}
	
	@Test
	public void homePageAppointmentBtnPresentTest()
	{
		Boolean state= homePage.verifyAppointmentBtnPresent();
		Assert.assertTrue(state);
	}
	
	@Test
	public void clickLoginBtnTest()
	{
		loginPage= homePage.clickloginBtn();
		Assert.assertEquals(loginPage.validateTitle(), "CURA Healthcare Service");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
