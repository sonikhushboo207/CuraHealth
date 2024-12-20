package com.cura.qa.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cura.qa.base.TestBase;
import com.cura.qa.report.ExtentReportUtils;

public class Apptmntpage extends TestBase{
	
	@FindBy(xpath="//h2[text()='Make Appointment']")
	WebElement heading;
	
	@FindBy(id="combo_facility")
	WebElement drpdown;

	@FindBy(id="chk_hospotal_readmission")
	WebElement checkBox;
	
	@FindBy(id="radio_program_medicare")
	WebElement radioBtn;
	
	@FindBy(id="txt_visit_date")
	WebElement visitDate;
	
	@FindBy(id="txt_comment")
	WebElement textComment;
	
	@FindBy(id="btn-book-appointment")
	WebElement bookBtn;
	
	@FindBy(xpath="//h2[text()='Appointment Confirmation']")
	WebElement confrmHeading;
	
	public Apptmntpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHeading()
	{
		ExtentReportUtils.addStep("Verifying the heading of the page.");
		return heading.getText();
	}
	
	public String makeAppointment()
	{
		Select select= new Select(drpdown);
		select.selectByVisibleText("Tokyo CURA Healthcare Center");
		ExtentReportUtils.addStep("Tokyo CURA Healthcare Center selected");
		checkBox.click();
		ExtentReportUtils.addStep("Checkbox selected");
		
		radioBtn.click();
		
		visitDate.sendKeys("30/11/2024");
		
		textComment.sendKeys("Normal body checkup");
		
		bookBtn.click();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Appointment Confirmation']")));
		
	    return confrmHeading.getText();
	}
	
	
}
