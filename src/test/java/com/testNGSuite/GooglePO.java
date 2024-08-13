package com.testNGSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePO{
	WebDriver driver;
	
	public GooglePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="textarea.gLFyf")
	WebElement txtSearch;
	
	@FindBy(how=How.CSS, using="a[href*='about.google/?']")
	WebElement lnkAbout;
	
}
