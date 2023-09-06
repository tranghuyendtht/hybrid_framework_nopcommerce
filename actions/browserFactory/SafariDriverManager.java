package browserFactory;

import org.openqa.selenium.WebDriver;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SafariDriverManager implements BrowserFactory{

	@Override
	public WebDriver getBrowserDriver() {
		if(!IS_OS_MAC) {
			throw new BrowserNotSupportException("Safari is not support on "+ System.getProperty("os.name"));
		}
		WebDriverManager.safaridriver().setup();
		SafariOptions options = new SafariOptions();
		return new SafariDriver(options);
	}

}
