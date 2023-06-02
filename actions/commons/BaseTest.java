package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.environment.EnvironmentUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PageUIs.nopcommerce.user.BasePageUI;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
	// Chứa các hàm dùng chung cho testcase
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {
		browserName = browserName.toUpperCase();
		System.out.println("Run on " + browserName);
		switch(browserName) {
		case "FIREFOX":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case "CHROME":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "EDGE":
			driver = WebDriverManager.edgedriver().create();
			break;
		case "COCCOC":
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = WebDriverManager.chromedriver().driverVersion("111.0.5563.64").capabilities(options).create();
			break;
		case "OPERA":
			driver = WebDriverManager.operadriver().create();
			break;
		default:
			throw new RuntimeException("Please check your browser name!");
			
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(GlobalConstants.USER_PAGE_URL);
		
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		browserName = browserName.toUpperCase();
		System.out.println("Run on " + browserName);
		switch(browserName) {
		case "FIREFOX":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case "CHROME":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "EDGE":
			driver = WebDriverManager.edgedriver().create();
			break;
		case "COCCOC":
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = WebDriverManager.chromedriver().driverVersion("111.0.5563.64").capabilities(options).create();
			break;
		case "OPERA":
			driver = WebDriverManager.operadriver().create();
			break;
		default:
			throw new RuntimeException("Please check your browser name!");
			
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appUrl);

		return driver;
	}
	
	private String getEnvironmentUrl (String serverName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if (environment == EnvironmentList.DEV) {
			envUrl = "https://demo.nopcommerce.com";
		} else if (environment == EnvironmentList.TESTING) {
			envUrl = "https://admin-demo.nopcommerce.com";
		} else if (environment == EnvironmentList.STAGING) {
			envUrl = "https://staging.orangehrmlive.com";
		} else if (environment == EnvironmentList.PRODUCTION) {
			envUrl = "https://production.orangehrmlive.com";
		}
		return envUrl;
	}
	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
