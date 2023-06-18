package javaBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Topic_15_Hard_Assert extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	//@Test
	public void TC_01_Hard_Assert() {
		
		
		// In hard assert, when the checkpoint is failed, the next checkpoint is not runned ( Assert 3)
		System.out.println("Assert 1 - Pass");
		String loginPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, "https://demo.nopcommerce.com/");
		
		System.out.println("Assert 2 - Fail");
		String loginPageTitle = driver.getTitle();
		Assert.assertEquals(loginPageTitle, "nopCommerce demo store...");
		
		System.out.println("Assert 3 - Pass");
		Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed());
		
	}
	
	@Test
	public void TC_02_Verify_CustomHardAssert() {

		
		// Trong CustomHardAssert, dù checkpoint có bị fail thì các checkpoint sau nó vẫn được chạy
		System.out.println("Assert 1 - Pass");
		String loginPageUrl = driver.getCurrentUrl();
		verifyEquals(loginPageUrl, "https://demo.nopcommerce.com/");

		System.out.println("Assert 2 - Fail");
		String loginPageTitle = driver.getTitle();
		verifyEquals(loginPageTitle, "nopCommerce demo store...");

		System.out.println("Assert 3 - Pass");
		verifyTrue(driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed());
		
		System.out.println("Assert 4 - Fail");
		verifyFalse(driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed());
		
		System.out.println("Assert 5 - Pass");
		verifyTrue(driver.findElement(By.xpath("//button[text()='Search']")).isDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
