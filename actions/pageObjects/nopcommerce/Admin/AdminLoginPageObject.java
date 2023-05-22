package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.admin.AdminLoginPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardpage(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox (password);
		return clickToLoginButton();
	}
}
