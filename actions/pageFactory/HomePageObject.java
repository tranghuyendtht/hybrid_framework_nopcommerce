package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageUIs.HomePageUI;
import commons.BasePage;
import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory{

	private WebDriver driver;
	
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	// UI
		@FindBy(className = "ico-register")
		private WebElement registerLink;
		
		@FindBy(className = "ico-login")
		private WebElement loginLink;
		
		@FindBy(xpath =  "//div[@class ='topic-block-title']//h2")
		private WebElement loginSuccessMessage;
		
		@FindBy(className = "ico-account")
		private WebElement myAccountLink;
		
		// Action

	public void clickToRegisterLink() {
		clickToElement(driver, registerLink);
		
	}


	public void clickToLoginLink() {
		clickToElement(driver, loginLink);
		
	}


	public String getLoginSuccessMessage() {
		waitForElementVisible(driver, loginSuccessMessage);
		return getElementText(driver, loginSuccessMessage);
	}


	public boolean isMyAccountLinkIsDisplay() {
		waitForElementVisible(driver,myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
		 
	}


	public void clickToMyAccountLink() {
		waitForElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
		
	}


	public boolean isRegisterLinkIsDisplayed() {
		waitForElementVisible(driver, registerLink);
		return isElementDisplayed(driver, registerLink);
		
	}

}
