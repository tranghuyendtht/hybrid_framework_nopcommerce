package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageUIs.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage{

	private WebDriver driver;
	
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}


	
	
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		// Page Generator 2
		// return new RegisterPageObject(driver);
		// Page Generator 3
		return PageGeneratorManager.getRegisterPage(driver);
	}


	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		//return new LoginPageObject(driver);
		return PageGeneratorManager.getLoginPage(driver);
	}


	public String getLoginSuccessMessage() {
		waitForElementVisible(driver, HomePageUI.LOGIN_SUCCESS_MESSAGE);
		return getElementText(driver, HomePageUI.LOGIN_SUCCESS_MESSAGE);
	}


	public boolean isMyAccountLinkIsDisplay() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
		 
	}


	public void clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		
	}


	public boolean isRegisterLinkIsDisplayed() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
		
	}

}
