package pageFactory;

import org.openqa.selenium.WebDriver;

import PageUIs.MyAccountPageUI;
import commons.BasePage;

public class MyAccountPageFactory extends BasePage {

	private WebDriver driver;

	public MyAccountPageFactory(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCustomerInfoLink() {
		waitForElementClickable(driver, MyAccountPageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, MyAccountPageUI.CUSTOMER_INFO_LINK);

	}

	public void clickToGenderRadio() {
		waitForElementClickable(driver, MyAccountPageUI.GENDER_RADIO);
		clickToElement(driver, MyAccountPageUI.GENDER_RADIO);

	}

	public void inputToFirstNameTextbox(String newFirstName) {
		waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, newFirstName);

	}

	public void inputToLastNameTextbox(String newLastName) {
		waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, newLastName);

	}

	public void selectDayOfBirth(String day) {
		waitForElementVisible(driver, MyAccountPageUI.DATE_OF_BIRTH_DAY_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, MyAccountPageUI.DATE_OF_BIRTH_DAY_DROPDOWN_LIST, day);

	}

	public void selectMonthOfBirth(String month) {
		waitForElementVisible(driver, MyAccountPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, MyAccountPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN_LIST, month);

	}

	public void selectYearOfBirth(String year) {
		waitForElementVisible(driver, MyAccountPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, MyAccountPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN_LIST, year);

	}

	public void inputToEmailTextbox(String newEmail) {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, newEmail);

	}

	public void inputToCompanyTextbox(String newCompanyName) {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.COMPANY_TEXTBOX, newCompanyName);

	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}

	public boolean isGenderIsSelected() {
		return getElementAtribute(driver, MyAccountPageUI.GENDER_RADIO, "checked").equalsIgnoreCase("true");

	}

	public boolean isFirstNameTextboxIsUpdated(String newFirstName) {

		return getElementAtribute(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, "value").equals(newFirstName);
	}

	public boolean isLastNameTextboxIsUpdated(String newLastName) {

		return getElementAtribute(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, "value").equals(newLastName);
	}

	public boolean isDayOfBirthIsUpdated(String day) {
		return getSelectedItemDefaultDropdown(driver, MyAccountPageUI.DATE_OF_BIRTH_DAY_DROPDOWN_LIST).equals(day);
	}

	public boolean isMonthOfBirthIsUpdated(String month) {
		return getSelectedItemDefaultDropdown(driver, MyAccountPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN_LIST).equals(month);
	}

	public boolean isYearOfBirthIsUpdated(String year) {

		return getSelectedItemDefaultDropdown(driver, MyAccountPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN_LIST).equals(year);
	}

	public boolean isCompanyTextboxIsUpdated(String newCompany) {
		return getElementAtribute(driver, MyAccountPageUI.COMPANY_TEXTBOX, "value").equals(newCompany);
	}

	public boolean isEmailTextboxIsUpdated(String newEmail) {

		return getElementAtribute(driver, MyAccountPageUI.EMAIL_TEXTBOX, "value").equals(newEmail);
	}

	public void closePopup() {
		waitForElementClickable(driver, MyAccountPageUI.POPUP);
		clickToElement(driver, MyAccountPageUI.POPUP);
	}

	public void clickToAddressLink() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_LINK);
		clickToElement(driver, MyAccountPageUI.ADDRESS_LINK);

	}

	public void clickToAddNewButton() {
		waitForElementVisible(driver, MyAccountPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADD_NEW_BUTTON);

	}

	public void inputToAddFirstNameTextbox(String addFirstName) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADD_FIRST_NAME_TEXTBOX, addFirstName);
	}

	public void inputToAddLastNameTextbox(String addLastName) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADD_LAST_NAME_TEXTBOX, addLastName);

	}

	public void inputToAddEmailTextbox(String addEmail) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADD_EMAIL_TEXTBOX, addEmail);

	}

	public void selectToAddCountryDropdownList(String addCountry) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_COUNTRY_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, MyAccountPageUI.ADD_COUNTRY_DROPDOWN_LIST, addCountry);

	}

	public void inputToAddCityTextbox(String addCity) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_CITY_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADD_CITY_TEXTBOX, addCity);

	}

	public void inputToAddAdressOneTextbox(String addAddress1) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_ADDRESS_1_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADD_ADDRESS_1_TEXTBOX, addAddress1);

	}

	public boolean isAddFirstNameTextboxIsUpdated(String addFirstName) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_NAME_UPDATED);
		return getElementText(driver, MyAccountPageUI.ADD_NAME_UPDATED).contains(addFirstName);
	}

	public boolean isAddLastNameTextboxIsUpdated(String addLastName) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_NAME_UPDATED);
		return getElementText(driver, MyAccountPageUI.ADD_NAME_UPDATED).contains(addLastName);
	}

	public boolean isAddPhoneTextboxIsUpdated(String addPhoneNumber) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_PHONE_UPDATED);
		return getElementText(driver, MyAccountPageUI.ADD_PHONE_UPDATED).contains(addPhoneNumber);
	}

	public boolean isAddEmailTextboxIsUpdated(String addEmail) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_EMAIL_UPDATED);
		return getElementText(driver, MyAccountPageUI.ADD_EMAIL_UPDATED).contains(addEmail);
	}

	public boolean isAddAddress1TextboxIsUpdated(String addAddress1) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_ADDRESS1_UPDATED);
		return getElementText(driver, MyAccountPageUI.ADD_ADDRESS1_UPDATED).contains(addAddress1);
	}

	public boolean isAddCityStateZipTextboxIsUpdated(String addCity) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_CITY_STATE_ZIP_UPDATED);
		return getElementText(driver, MyAccountPageUI.ADD_CITY_STATE_ZIP_UPDATED).contains(addCity);
	}

	public boolean isAddCountryDropdownListIsUpdated(String addCountry) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_COUNTRY_UPDATED);
		return getElementText(driver, MyAccountPageUI.ADD_COUNTRY_UPDATED).contains(addCountry);

	}

	public boolean isTitleIsDisplayed(String firstName) {
		return getElementText(driver, MyAccountPageUI.TITLE_RESULT).contains(firstName);
	}

	public void clickToSaveAddressButton() {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_ADDRESS_BUTTON);

	}

	public void inputToZipCodePortalTextbox(String addPostalCode) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_ZIP_POSTAL_CODE_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADD_ZIP_POSTAL_CODE_TEXTBOX, addPostalCode);

	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);

	}

	public void inputToPhoneNumberTextbox(String addPhoneNumber) {
		waitForElementVisible(driver, MyAccountPageUI.ADD_PHONE_NUMBER_TEXTBOX);

		sendkeyToElement(driver, MyAccountPageUI.ADD_PHONE_NUMBER_TEXTBOX, addPhoneNumber);
	}

	public void clickToChangePasswordLink() {
		waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
	}

	public void inputToOldPasswordTextbox(String password) {
		waitForElementVisible(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX, password);

	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX, newPassword);

	}

	public void inputToConfirmNewPasswordTextbox(String confirmNewPassword) {
		waitForElementVisible(driver, MyAccountPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, confirmNewPassword);
	}

	public String getSuccessfulNotificationAtBar() {
		waitForElementVisible(driver, MyAccountPageUI.SUCCESSFUL_NOTIFICATION_BAR);
		return getElementText(driver, MyAccountPageUI.SUCCESSFUL_NOTIFICATION_BAR);
	}

	public void clickToClosePopup() {
		waitForElementClickable(driver, MyAccountPageUI.SUCCESSFUL_NOTIFICATION_CLOSE_ICON);
		clickToElement(driver, MyAccountPageUI.SUCCESSFUL_NOTIFICATION_CLOSE_ICON);

	}

	public void clickToLogOutLink() {
		waitForElementClickable(driver, MyAccountPageUI.LOGOUT_LINK);
		clickToElementByJS(driver, MyAccountPageUI.LOGOUT_LINK);

	}

	public boolean isSuccessNotiBarIsDisplayed(String noti) {
		waitForAllElementVisible(driver, MyAccountPageUI.ADD_SUCCESSFUL_NOTI_BAR);
		return getElementText(driver, MyAccountPageUI.ADD_SUCCESSFUL_NOTI_BAR).equals(noti);
	}

	public void clickToCloseNotiBar() {
		waitForElementClickable(driver, MyAccountPageUI.ADD_SUCCESSFUL_NOTI_CLOSE_ICON);
		clickToElement(driver, MyAccountPageUI.ADD_SUCCESSFUL_NOTI_CLOSE_ICON);

	}

	public void clickToComputerLink() {
		waitForElementClickable(driver, MyAccountPageUI.PRODUCT_LIST_COMPUTERS_LINK);
		clickToElement(driver, MyAccountPageUI.PRODUCT_LIST_COMPUTERS_LINK);

	}

	public void clickToMyProductReview() {
		waitForElementClickable(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
	}

	public boolean isReviewTitleIsUpdated(String reviewTitle) {
		waitForAllElementVisible(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_TITLE_TEXT);
		return getElementText(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_TITLE_TEXT).contains(reviewTitle);
	}

	public boolean isReviewBodyIsUpdated(String reviewBody) {
		waitForAllElementVisible(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_BODY_TEXT);
		return getElementText(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_BODY_TEXT).contains(reviewBody);
	}

}
