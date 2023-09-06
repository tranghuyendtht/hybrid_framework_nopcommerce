package environmentFactory;

import org.openqa.selenium.WebDriver;

import browserFactory.BrowserList;
import browserFactory.BrowserNotSupportException;
import browserFactory.ChromeDriverManager;
import browserFactory.CoccocDriverManager;
import browserFactory.EdgeDriverManager;
import browserFactory.FirefoxDriverManager;
import browserFactory.HeadlessChromeDriverManager;
import browserFactory.HeadlessFirefoxDriverManager;
import browserFactory.OperaDriverManager;
import browserFactory.SafariDriverManager;

public class LocalFactory implements EnvironmentFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	@Override
	public WebDriver createDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX:
			driver = new FirefoxDriverManager().getBrowserDriver();
			break;
		case CHROME:
			driver = new ChromeDriverManager().getBrowserDriver();
			break;
		case EDGE:
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
		case COCCOC:
			driver = new CoccocDriverManager().getBrowserDriver();
			break;
		case OPERA:
			driver = new OperaDriverManager().getBrowserDriver();
			break;
		case SAFARI:
			driver = new SafariDriverManager().getBrowserDriver();
			break;
		case H_CHROME:
			driver = new HeadlessChromeDriverManager().getBrowserDriver();
			break;
		case H_FIREFOX:
			driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
			break;
			
		default:
			throw new BrowserNotSupportException(browserName);
		}
		return driver;

	}

}
