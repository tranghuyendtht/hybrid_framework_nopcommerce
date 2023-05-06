package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage{

	private WebDriver driver;
	
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}


	public void clickToRegisterLink() {
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		
	}


	public void clickToLoginLink() {
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		
	}


	public String getLoginSuccessMessage() {
		waitForElementVisible(driver, HomePageUI.LOGIN_SUCCESS_MESSAGE);
		return getElementText(driver, HomePageUI.LOGIN_SUCCESS_MESSAGE);
	}

}
