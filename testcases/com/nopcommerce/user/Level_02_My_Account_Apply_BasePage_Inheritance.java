package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_My_Account_Apply_BasePage_Inheritance extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress = "automation" + fakeNumber() + "@mail.com";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@BeforeMethod
	public void beforeMethod() {

		// Register
		clickToElement(driver, "//a[@class = 'ico-register']");
		sendkeyToElement(driver, "//input[@id = 'FirstName']", "automation");
		sendkeyToElement(driver, "//input[@id = 'LastName']", "fc");
		sendkeyToElement(driver, "//input[@id = 'Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id = 'Password']", "123456");
		sendkeyToElement(driver, "//input[@id = 'ConfirmPassword']", "123456");
		clickToElement(driver, "//button[@id = 'register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class = 'result']"), "Your registration completed");

		// Login
		clickToElement(driver, "//a[@class = 'ico-login']");
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		waitForElementVisible(driver, "//div[@class ='topic-block-title']//h2");
		Assert.assertEquals(getElementText(driver, "//div[@class ='topic-block-title']//h2"), "Welcome to our store");
	}

	@Test
	public void TC_01_Customer_Info() {
		waitForElementVisible(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[@class='ico-account']");

		clickToElement(driver, "//a[text()='Customer info']");
		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		sendkeyToElement(driver, "//input[@id='LastName']", "FC");

		selectItemInDefaultDropDown(driver, "//select[@name ='DateOfBirthDay']", "1");
		selectItemInDefaultDropDown(driver, "//select[@name ='DateOfBirthMonth']", "January");
		selectItemInDefaultDropDown(driver, "//select[@name ='DateOfBirthYear']", "1999");
		sendkeyToElement(driver, "//input[@id='Email']", "automationfc.vn@mail.com");
		sendkeyToElement(driver, "//input[@id='Company']", "Automation FC");
		clickToElement(driver, "//button[@id='save-info-button']");
		

	}

	// @AfterMethod
	public void afterMethod() {
		clickToElement(driver, "//a[@class='ico-logout']");
		waitForElementVisible(driver, "//div[@class ='topic-block-title']//h2");
		Assert.assertEquals(getElementText(driver, "//div[@class ='topic-block-title']//h2"), "Welcome to our store");

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
