package com.cura.qa.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cura.qa.base.TestBase;
import com.cura.qa.utils.TestUtil;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[@id='menu-toggle']/i")
	WebElement toggleMenu;

	@FindBy(xpath="//a[text()='Login']")
	WebElement loginLink;
	
	@FindBy(xpath="//h1[text()=\"CURA Healthcare Service\"]")
	WebElement heading1;
	
	@FindBy(xpath="//h3[text()=\"We Care About Your Health\"]")
	WebElement heading2;
	
	@FindBy(id="btn-make-appointment")
	WebElement AppointmentBtn;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyHeading()
	{
		String heading1Text= heading1.getText();
		return heading1Text;
	}
	
	public String verifyHeading2()
	{
		String heading2Text= heading2.getText();
		return heading2Text;
	}
	
	public Boolean verifyAppointmentBtnPresent()
	{
		return AppointmentBtn.isDisplayed();
	}
	
	public LoginPage clickloginBtn()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		toggleMenu.click();
		loginLink.click();
		return new LoginPage();
		
	}
	
	
}
