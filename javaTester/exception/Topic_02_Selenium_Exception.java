package exception;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Topic_02_Selenium_Exception {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	@BeforeClass
	public void beforeClass() {
		if(osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath+ "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	//@Test
	public void TC_01_noSuchElementException() {
		// Lỗi phổ biến nhất: Không tìm thấy element
		driver.get("http://live.techpanda.org/");
		WebElement buttonX = driver.findElement(By.xpath("//a[text() ='Mobilee']"));
		buttonX.click();
	}
	
	//@Test
	public void TC_02_staleElementReferenceException() {
		// Element vẫn còn trong DOM, nhưng bị thay đổi trạng thái  (DOM bị render lại)
		/* The element with the reference 8266d8b9-aca6-4e39-ab8e-5ef8df856a09 is stale; 
		/either its node document is not the active document, or it is no longer connected to the DOM
		 */

		WebDriverWait explicitWait = new WebDriverWait(driver,10);
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		// Chờ cho tới khi element xuất hiện
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_Panel1")));
		
		// Verify chưa được click
		WebElement dataNoSelected = driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"));
		Assert.assertEquals("No Selected Dates to display.", dataNoSelected.getText());
		
		
		// Click vào ngày bất kỳ
		WebElement daySelected = driver.findElement(By.xpath("//a[text()='12']"));
		daySelected.click();
		
		// Chờ tới khi icon loading bị biến mất
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ctl00_ContentPlaceholder1_RadAjaxLoadingPanel1ctl00_ContentPlaceholder1_RadCalendar1 div.raDiv")));
		
		// Chờ tới khi text xuất hiện
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")));
		
		// Verify text sau khi click
		Assert.assertTrue(dataNoSelected.getText().contains("12"));
	}
	
	//@Test
	public void TC_03_elementNotVisibleException() {
		
		// Element có trong DOM nhưng bị che mất bởi element khác - selenium 2.x
		// Element could not be scrolled into view
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//header[@id ='header']//a[text()='My Account']")).click();
		
		
	}
	
//	@Test
	public void TC_04_elementNotInteractableException() {
		// Giống của TC 3 - cho selenium 3.x
	}
	
	//@Test
	public void TC_05_noAlertPresentException() {
		// Không thấy alert để thực thi
		driver.get("http://live.techpanda.org/");
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void TC_06_invalidSelectorException() {
		// Truyền sai cú pháp selector
		// Given css selector expression "//header[@id ='header']//a[text()='My Account']" is invalid
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.cssSelector("//header[@id ='header']//a[text()='My Account']")).click();
	}
	
	@Test
	public void TC_07_elementNotSelectableException() {
		// Element đang bị disable, không thao tác được
	}
	
	@Test
	public void TC_08_noSuchFrameException() {
		// Không thấy Frame/iFrame để thực thi
	}
	
	@Test
	public void TC_09_noSuchWindowException() {
		// Không thấy windows để thực thi (hoặc windows đã bị đóng)
	}
	
	@Test
	public void TC_10_sessionNotFoundException() {
		// Vẫn tương tác với browser sau khi đã bị đóng - Selenium 2.x
	}
	
	@Test
	public void TC_11_noSuchSessionException() {
		// Vẫn tương tác với browser sau khi đã bị đóng - Selenium 3.x
	}
	
	@Test
	public void TC_12_timeoutException() {
		// Liên quan tới FluentWait
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

