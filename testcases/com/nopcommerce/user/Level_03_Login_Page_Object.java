package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Login_Page_Object extends BasePage {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	String emailAddress;
	String firstName, lastName, password;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		loginPage = new LoginPageObject(driver);
		emailAddress = "automation" + fakeNumber() + "@mail.com";
		firstName = "Automation";
		lastName = "FC";
		password = "123456";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Login_Empty_Data() {

		System.out.println("HomePage - Step 01: Click to Login Link");
		homePage.clickToLoginLink();
		System.out.println("LoginPage - Step 02: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("LoginPage - Step 03: Verify error message at email textbox");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		System.out.println("HomePage - Step 01: Click to Login Link");
		homePage.clickToLoginLink();

		System.out.println("LoginPage - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox("12345@123@");
		loginPage.inputToPasswordTextbox("123456");

		System.out.println("LoginPage - Step 03: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("LoginPage - Step 04: Verify error message at email textbox");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void TC_03_Login_New_Email() {
		System.out.println("HomePage - Step 01: Click to Login Link");
		homePage.clickToLoginLink();

		System.out.println("LoginPage - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox("123xjha@mail.com");
		loginPage.inputToPasswordTextbox("123456");

		System.out.println("LoginPage - Step 03: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("LoginPage - Step 04: Verify error message at email textbox");

		Assert.assertEquals(loginPage.getErrorMessageForIncorrectInput(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_04_Login_Empty_Password() {
		//String emailAddress = "automation" + fakeNumber() + "@mail.com";
		System.out.println("HomePage - Step 01: Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("RegisterPage - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage - Step 04: Verify result register successfully");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("RegisterPage - Step 05: Click to Login Link");
		registerPage.clickToLoginLink();

		System.out.println("LoginPage - Step 06: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);

		System.out.println("LoginPage - Step 07: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("LoginPage - Step 08: Verify error message for incorrect data input");
		Assert.assertEquals(loginPage.getErrorMessageForIncorrectInput(),
				"Login was unsuccessful. Please correct the errors and try again.\n"
						+ "The credentials provided are incorrect");
	}

	@Test
	public void TC_05_Login_Invalid_Password() {
		
		// Login

		System.out.println("RegisterPage - Step 05: Click to Login Link");
		registerPage.clickToLoginLink();

		System.out.println("LoginPage - Step 06: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123000");

		System.out.println("LoginPage - Step 07: Click to Login Button");
		loginPage.clickToLoginButton();
		// clickToElement(driver, "//button[contains(@class,'login-button')]");

		System.out.println("LoginPage - Step 08: Verify error message for incorrect data input");
		Assert.assertEquals(loginPage.getErrorMessageForIncorrectInput(),
				"Login was unsuccessful. Please correct the errors and try again.\n"
						+ "The credentials provided are incorrect");

	}

	@Test
	public void TC_06_Login_Success() {


		// Login

		System.out.println("RegisterPage - Step 05: Click to Login Link");
		registerPage.clickToLoginLink();

		System.out.println("LoginPage - Step 06: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123456");

		System.out.println("LoginPage - Step 07: Click to Login Button");
		loginPage.clickToLoginButton();
		// clickToElement(driver, "//button[contains(@class,'login-button')]");

		System.out.println("LoginPage - Step 08: Verify success message displayed");
		Assert.assertEquals(homePage.getLoginSuccessMessage(), "Welcome to our store");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
