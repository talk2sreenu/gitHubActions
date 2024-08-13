package com.testNGSuite;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTests {
	WebDriver driver;
	
	@BeforeTest
	void initializeDriver() {
		WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--no-sandbox");
		 options.addArguments("--disable-dev-shm-usage");
		 options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@Test
	void verifyApplicationPage() throws InterruptedException {
		GooglePO gpo = new GooglePO(driver);
		
		driver.get("https://www.google.com");
		gpo.txtSearch.isDisplayed();
		gpo.lnkAbout.click();
		Thread.sleep(5000);
		String pageTitle = driver.getTitle();
		
		Assert.assertTrue(pageTitle.contains("About"));
		System.out.println("Test Execution completed successfully");
	}
	
	@AfterTest
	void closeDriver() {
		driver.close();
	}
}
