package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageFactory extends BasePageFactory{
	private WebDriver driver;
	
	
	// UI
	@FindBy(id = "register-button")
	private WebElement registerButton;
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	@FindBy(id = "FirstName-error")
	private WebElement firstNameErrorMessage;
	@FindBy(id = "LastName-error")
	private WebElement lastNameErrorMessage;
	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;
	@FindBy(id = "Password-error")
	private WebElement passwordErrorMessage;
	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordError;
	@FindBy(className =  "result")
	private WebElement registerSuccessMessage;
	@FindBy(className  = "ico-logout")
	private WebElement logoutLink;
	@FindBy(xpath = "//div[contains(@class, 'message-error')]//li")
	private WebElement emailExistingErrorMessage;
	@FindBy(className = "ico-login")
	private WebElement loginLink;
	
	// Action

	public RegisterPageFactory(WebDriver mappingDriver) {
		driver = mappingDriver;
		PageFactory.initElements(driver, this);
	}

	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordError);
		return getElementText(driver, confirmPasswordError);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
		
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver,emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
		
	}
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
		
	}

	

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, emailExistingErrorMessage);
		return getElementText(driver, emailExistingErrorMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
		
	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		
	}


}
