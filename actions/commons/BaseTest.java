package commons;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		driver.get("https://demo.nopcommerce.com/");

		return driver;
	}

}
