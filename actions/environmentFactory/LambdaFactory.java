package environmentFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import commons.GlobalConstants;

public class LambdaFactory implements EnvironmentFactory{
	private WebDriver driver;
	private String browserName;
	private String osName;
	private String osVersion;
	
	public LambdaFactory(String browserName, String osName, String osVersion) {
		this.browserName = browserName;
		this.osName = osName;
		this.osVersion = osVersion;
	}

	@Override
	public WebDriver createDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("platform", osName);
		capabilities.setCapability("version", osVersion);
		capabilities.setCapability("video", true);
		capabilities.setCapability("visual", true);
		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", GlobalConstants.LAMBDA_USERNAME);
		ltOptions.put("accessKey", GlobalConstants.LAMBDA_ACCESS_KEY);
		ltOptions.put("project", "Untitled");
		ltOptions.put("selenium_version", "3.141.59");
		ltOptions.put("w3c", true);
		capabilities.setCapability("LT:Options", ltOptions);
		
		if(osName.contains("Windows")) {
			capabilities.setCapability("screenResolution", "1920x1080");
		} else {
			capabilities.setCapability("screenResolution", "2560x1600");
		}
		capabilities.setCapability("name","Run on" + osName + "|" + browserName);
		
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL),capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

}
