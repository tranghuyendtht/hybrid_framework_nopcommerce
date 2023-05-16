package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.BasePageUI;
import PageUIs.CustomerInfoPageUI;
import commons.BasePage;

public class CustomerInfoPageObject extends BasePage {

	private WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGenderRadio() {
		waitForElementClickable(driver, CustomerInfoPageUI.GENDER_RADIO);
		clickToElement(driver, CustomerInfoPageUI.GENDER_RADIO);

	}

	public void inputToFirstNameTextbox(String newFirstName) {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, newFirstName);

	}

	public void inputToLastNameTextbox(String newLastName) {
		waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, newLastName);

	}

	public void selectDayOfBirth(String day) {
		waitForElementVisible(driver, CustomerInfoPageUI.DATE_OF_BIRTH_DAY_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_DAY_DROPDOWN_LIST, day);

	}

	public void selectMonthOfBirth(String month) {
		waitForElementVisible(driver, CustomerInfoPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN_LIST, month);

	}

	public void selectYearOfBirth(String year) {
		waitForElementVisible(driver, CustomerInfoPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN_LIST, year);

	}

	public void inputToEmailTextbox(String newEmail) {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, newEmail);

	}

	public void inputToCompanyTextbox(String newCompanyName) {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, newCompanyName);

	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
	}

	public boolean isGenderIsSelected() {
		return getElementAtribute(driver, CustomerInfoPageUI.GENDER_RADIO, "checked").equalsIgnoreCase("true");

	}

	public boolean isFirstNameTextboxIsUpdated(String newFirstName) {

		return getElementAtribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value").equals(newFirstName);
	}

	public boolean isLastNameTextboxIsUpdated(String newLastName) {

		return getElementAtribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value").equals(newLastName);
	}

	public boolean isDayOfBirthIsUpdated(String day) {
		return getSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_DAY_DROPDOWN_LIST).equals(day);
	}

	public boolean isMonthOfBirthIsUpdated(String month) {
		return getSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN_LIST)
				.equals(month);
	}

	public boolean isYearOfBirthIsUpdated(String year) {

		return getSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN_LIST).equals(year);
	}

	public boolean isCompanyTextboxIsUpdated(String newCompany) {
		return getElementAtribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value").equals(newCompany);
	}

	public boolean isEmailTextboxIsUpdated(String newEmail) {

		return getElementAtribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value").equals(newEmail);
	}

	public void closePopup() {
		waitForElementClickable(driver, CustomerInfoPageUI.POPUP);
		clickToElement(driver, CustomerInfoPageUI.POPUP);
	}

	public void clickToAddNewButton() {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.ADD_NEW_BUTTON);

	}

	public void inputToAddFirstNameTextbox(String addFirstName) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.ADD_FIRST_NAME_TEXTBOX, addFirstName);
	}

	public void inputToAddLastNameTextbox(String addLastName) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.ADD_LAST_NAME_TEXTBOX, addLastName);

	}

	public void inputToAddEmailTextbox(String addEmail) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.ADD_EMAIL_TEXTBOX, addEmail);

	}

	public void selectToAddCountryDropdownList(String addCountry) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_COUNTRY_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, CustomerInfoPageUI.ADD_COUNTRY_DROPDOWN_LIST, addCountry);

	}

	public void inputToAddCityTextbox(String addCity) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_CITY_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.ADD_CITY_TEXTBOX, addCity);

	}

	public void inputToAddAdressOneTextbox(String addAddress1) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_ADDRESS_1_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.ADD_ADDRESS_1_TEXTBOX, addAddress1);

	}

	public boolean isAddFirstNameTextboxIsUpdated(String addFirstName) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_NAME_UPDATED);
		return getElementText(driver, CustomerInfoPageUI.ADD_NAME_UPDATED).contains(addFirstName);
	}

	public boolean isAddLastNameTextboxIsUpdated(String addLastName) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_NAME_UPDATED);
		return getElementText(driver, CustomerInfoPageUI.ADD_NAME_UPDATED).contains(addLastName);
	}

	public boolean isAddPhoneTextboxIsUpdated(String addPhoneNumber) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_PHONE_UPDATED);
		return getElementText(driver, CustomerInfoPageUI.ADD_PHONE_UPDATED).contains(addPhoneNumber);
	}

	public boolean isAddEmailTextboxIsUpdated(String addEmail) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_EMAIL_UPDATED);
		return getElementText(driver, CustomerInfoPageUI.ADD_EMAIL_UPDATED).contains(addEmail);
	}

	public boolean isAddAddress1TextboxIsUpdated(String addAddress1) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_ADDRESS1_UPDATED);
		return getElementText(driver, CustomerInfoPageUI.ADD_ADDRESS1_UPDATED).contains(addAddress1);
	}

	public boolean isAddCityStateZipTextboxIsUpdated(String addCity) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_CITY_STATE_ZIP_UPDATED);
		return getElementText(driver, CustomerInfoPageUI.ADD_CITY_STATE_ZIP_UPDATED).contains(addCity);
	}

	public boolean isAddCountryDropdownListIsUpdated(String addCountry) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_COUNTRY_UPDATED);
		return getElementText(driver, CustomerInfoPageUI.ADD_COUNTRY_UPDATED).contains(addCountry);

	}

	public boolean isTitleIsDisplayed(String firstName) {
		return getElementText(driver, CustomerInfoPageUI.TITLE_RESULT).contains(firstName);
	}

	public void clickToSaveAddressButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_ADDRESS_BUTTON);

	}

	public void inputToZipCodePortalTextbox(String addPostalCode) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_ZIP_POSTAL_CODE_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.ADD_ZIP_POSTAL_CODE_TEXTBOX, addPostalCode);

	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.CHANGE_PASSWORD_BUTTON);

	}

	public void inputToPhoneNumberTextbox(String addPhoneNumber) {
		waitForElementVisible(driver, CustomerInfoPageUI.ADD_PHONE_NUMBER_TEXTBOX);

		sendkeyToElement(driver, CustomerInfoPageUI.ADD_PHONE_NUMBER_TEXTBOX, addPhoneNumber);
	}

	public void clickToChangePasswordLink() {
		waitForElementClickable(driver, CustomerInfoPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, CustomerInfoPageUI.CHANGE_PASSWORD_LINK);
	}

	public void inputToOldPasswordTextbox(String password) {
		waitForElementVisible(driver, CustomerInfoPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.OLD_PASSWORD_TEXTBOX, password);

	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, CustomerInfoPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.NEW_PASSWORD_TEXTBOX, newPassword);

	}

	public void inputToConfirmNewPasswordTextbox(String confirmNewPassword) {
		waitForElementVisible(driver, CustomerInfoPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, confirmNewPassword);
	}

	public String getSuccessfulNotificationAtBar() {
		waitForElementVisible(driver, CustomerInfoPageUI.SUCCESSFUL_NOTIFICATION_BAR);
		return getElementText(driver, CustomerInfoPageUI.SUCCESSFUL_NOTIFICATION_BAR);
	}

	public void clickToClosePopup() {
		waitForElementClickable(driver, CustomerInfoPageUI.SUCCESSFUL_NOTIFICATION_CLOSE_ICON);
		clickToElement(driver, CustomerInfoPageUI.SUCCESSFUL_NOTIFICATION_CLOSE_ICON);

	}

	public void clickToLogOutLink() {
		waitForElementClickable(driver, CustomerInfoPageUI.LOGOUT_LINK);
		clickToElementByJS(driver, CustomerInfoPageUI.LOGOUT_LINK);

	}

	public boolean isSuccessNotiBarIsDisplayed(String noti) {
		waitForAllElementVisible(driver, CustomerInfoPageUI.ADD_SUCCESSFUL_NOTI_BAR);
		return getElementText(driver, CustomerInfoPageUI.ADD_SUCCESSFUL_NOTI_BAR).equals(noti);
	}

	public void clickToCloseNotiBar() {
		waitForElementClickable(driver, CustomerInfoPageUI.ADD_SUCCESSFUL_NOTI_CLOSE_ICON);
		clickToElement(driver, CustomerInfoPageUI.ADD_SUCCESSFUL_NOTI_CLOSE_ICON);

	}

	public ProductListPageObject clickToComputerLink() {
		waitForElementClickable(driver, CustomerInfoPageUI.PRODUCT_LIST_COMPUTERS_LINK);
		clickToElement(driver, CustomerInfoPageUI.PRODUCT_LIST_COMPUTERS_LINK);
		return PageGeneratorManager.getProductListPageObject(driver);
	}

	public void clickToMyProductReview() {
		waitForElementClickable(driver, CustomerInfoPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, CustomerInfoPageUI.MY_PRODUCT_REVIEW_LINK);
	}

	public boolean isReviewTitleIsUpdated(String reviewTitle) {
		waitForAllElementVisible(driver, CustomerInfoPageUI.MY_PRODUCT_REVIEW_TITLE_TEXT);
		return getElementText(driver, CustomerInfoPageUI.MY_PRODUCT_REVIEW_TITLE_TEXT).contains(reviewTitle);
	}

	public boolean isReviewBodyIsUpdated(String reviewBody) {
		waitForAllElementVisible(driver, CustomerInfoPageUI.MY_PRODUCT_REVIEW_BODY_TEXT);
		return getElementText(driver, CustomerInfoPageUI.MY_PRODUCT_REVIEW_BODY_TEXT).contains(reviewBody);
	}
	public void clickToAddressLink() {
		waitForElementClickable(driver, CustomerInfoPageUI.ADDRESS_LINK);
		clickToElement(driver, CustomerInfoPageUI.ADDRESS_LINK);
		
	}
	public void clickToCustomerInfoLink() {
		waitForElementClickable(driver, CustomerInfoPageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, CustomerInfoPageUI.CUSTOMER_INFO_LINK);

	}

}
