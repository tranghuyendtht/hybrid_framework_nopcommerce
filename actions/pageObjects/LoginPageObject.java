package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX,email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password);
		
	}

	public String getErrorMessageForIncorrectInput() {
		waitForElementVisible(driver, LoginPageUI.ERROR_INCORRECT_INPUT);
		return getElementText(driver, LoginPageUI.ERROR_INCORRECT_INPUT);
	}



}
