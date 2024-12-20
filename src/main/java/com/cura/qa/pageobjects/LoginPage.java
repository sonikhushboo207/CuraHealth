package com.cura.qa.pageobjects;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cura.qa.base.TestBase;
import com.cura.qa.report.ExtentReportUtils;
import com.cura.qa.utils.TestUtil;

public class LoginPage extends TestBase{
	
	//Page Factory -Object Repository
	
	@FindBy(id="txt-username")
	WebElement username;
	
	@FindBy(id= "txt-password")
	WebElement password;
	
	@FindBy(id= "btn-login")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"login\"]/div/div/div[1]/h2")
	WebElement heading;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHeading()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		return heading.getText();
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public Apptmntpage validateLogin(String un, String pwd)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new Apptmntpage();
		
	}

}
