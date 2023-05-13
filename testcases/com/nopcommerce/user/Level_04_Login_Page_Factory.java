package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_04_Login_Page_Factory extends BaseTest{

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	String emailAddress;
	String firstName, lastName, password, invalidEmail, notFoundEmail;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		
		homePage = new HomePageObject(driver);
		
		registerPage = new RegisterPageObject(driver);
		
		emailAddress = "automation" + fakeNumber() + "@mail.com";
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		invalidEmail = "12345@123@";
		notFoundEmail =  "123xjha@mail.com";

		// Pre-Condition
		System.out.println("Pre-Condition - Step 01: Click to register link");
		homePage.clickToRegisterLink();
		loginPage = new LoginPageObject(driver);

		System.out.println("Pre-Condition - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-Condition - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify result register successfully");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void Login_001_Empty_Data() {

		System.out.println("HomePage - Step 01: Click to Login Link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		System.out.println("LoginPage - Step 02: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("LoginPage - Step 03: Verify error message at email textbox");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_002_Invalid_Email() {
		System.out.println("HomePage - Step 01: Click to Login Link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		System.out.println("LoginPage - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("LoginPage - Step 03: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("LoginPage - Step 04: Verify error message at email textbox");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_003_Not_Found_Email() {
		System.out.println("HomePage - Step 01: Click to Login Link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		System.out.println("LoginPage - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("LoginPage - Step 03: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("LoginPage - Step 04: Verify error message at email textbox");

		Assert.assertEquals(loginPage.getErrorMessageForIncorrectInput(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void Login_004_Empty_Password() {
		System.out.println("HomePage - Step 01: Click to Register Link");
		

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
	public void Login_005_Invalid_Password() {
		
		// Login

		System.out.println("RegisterPage - Step 05: Click to Login Link");
		registerPage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		System.out.println("LoginPage - Step 06: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123000");

		System.out.println("LoginPage - Step 07: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("LoginPage - Step 08: Verify error message for incorrect data input");
		Assert.assertEquals(loginPage.getErrorMessageForIncorrectInput(),
				"Login was unsuccessful. Please correct the errors and try again.\n"
						+ "The credentials provided are incorrect");

	}

	@Test
	public void Login_006_Login_Success() {


		// Login

		System.out.println("RegisterPage - Step 05: Click to Login Link");
		registerPage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		System.out.println("LoginPage - Step 06: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123456");

		System.out.println("LoginPage - Step 07: Click to Login Button");
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);

		
		System.out.println("LoginPage - Step 08: Verify success message displayed");
		Assert.assertTrue(homePage.isMyAccountLinkIsDisplay());

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
