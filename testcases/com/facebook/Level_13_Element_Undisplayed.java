package com.facebook;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.Facebook.LoginPageObject;
import pageObjects.Facebook.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserAddressPageObject;
import pageObjects.nopcommerce.User.UserBackInStockSubscriptionsPageObject;
import pageObjects.nopcommerce.User.UserChangePasswordPageObject;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserDownloadableProductPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserMyAccountPageObject;
import pageObjects.nopcommerce.User.UserMyProductReviewsPageObject;
import pageObjects.nopcommerce.User.UserOrderPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;
import pageObjects.nopcommerce.User.UserRewardPointsPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BackgroundInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_13_Element_Undisplayed extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlApp) {
		driver = getBrowserDriver(browserName, urlApp);
		loginPage = PageGeneratorManager.getLoginPage(driver);

	}

	@Test
	public void TC_01_Element_Displayed() {
		
		System.out.println("B1: Click to Button");
		loginPage.clickToCreateNewAccountButton();

		System.out.println("B2: Verify element displayed");
		// Một element có hiển thị ==> dùng wait to Element và check is displayed
		
		// Case 1: Element visible/displayed
		verifyTrue(loginPage.isEmailAddressTextboxIsDisplayed());
		

	}

	@Test
	public void TC_02_Element_Undisplayed__But_In_DOM() {
		// Một Element ko hiển thị có thể có trong dom hoặc không thì không được sử dụng
		// wait vì sẽ tốn thời gian chờ chạy hết timeout rồi mới đi tiếp nếu như nó ko
		// có trong DOM ==> cần custom lại implicitwait với TC02 và TC03
		
		System.out.println("B3: Input to Email textbox");
		loginPage.inputToEmailAddressTextbox("");
		System.out.println("B4: Verify confirmEmail Display");
		// Case 2: Element có trong DOM nhưng invisible/undisplayed
		verifyTrue(loginPage.isConfirmEmailAddressTextboxIsUndisplayed());
	}

	@Test
	public void TC_03_Element_Undisplay_And_Not_In_DOM() {
		loginPage.clickToSignUpCloseIcon();
		loginPage.sleepInSecond(3);
		// Sau khi đóng icon close của popip signup đi, element Confirm Email sẽ không còn trong DOM nữa
		// Nên hàm findElement sẽ bị fail khi tìm element (NoSuchElement)
		// 1: Chờ hết timeout: 30s
		// 2: Đánh fail TC
		// 3: Không chạy các step sau đó nữa
		
		// Case 3: Element không có trong DOM
		verifyTrue(loginPage.isConfirmEmailAddressTextboxIsUndisplayed());
		
		

	}

	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}

}
