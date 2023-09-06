package environmentFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import browserFactory.BrowserList;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GridFactory implements EnvironmentFactory {

	private WebDriver driver;
	private String browserName;
	private String ipAddress;
	private String portNumber;

	public GridFactory(String browserName, String osName, String ipAddress, String portNumber) {

		this.browserName = browserName;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}

	@Override
	public WebDriver createDriver() {
		DesiredCapabilities capability = null;
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);

			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.merge(capability);
			break;

		case CHROME:
			WebDriverManager.chromedriver().setup();
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.ANY);

			ChromeOptions cOptions = new ChromeOptions();
			cOptions.merge(capability);
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case COCCOC:
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = WebDriverManager.chromedriver().driverVersion("111.0.5563.64").capabilities(options).create();
			break;

		case OPERA:
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;

		case H_CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions hOptions = new ChromeOptions();
			hOptions.setHeadless(true);
			hOptions.addArguments("window-size=1920x1080");
			hOptions.addArguments("--incognito");
			driver = new ChromeDriver(hOptions);

		case H_FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions hfOptions = new FirefoxOptions();
			hfOptions.addArguments("--incognito");
			hfOptions.addArguments("--disable-infobars");
			hfOptions.addArguments("--disable-notifications");
			hfOptions.setAcceptInsecureCerts(true);

			driver = new FirefoxDriver(hfOptions);
		default:
			throw new RuntimeException("Browser is not valid!");
		}
		
		try {
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)),
					capability);
			System.out.println(String.format("http://%s:%s/wd/hub", ipAddress, portNumber));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return driver;
	}
}