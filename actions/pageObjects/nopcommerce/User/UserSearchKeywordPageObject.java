package pageObjects.nopcommerce.User;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageUIs.nopcommerce.user.UserSearchKeywordPageUI;
import commons.BasePage;

public class UserSearchKeywordPageObject extends BasePage {
	
	private WebDriver driver;
	
	public UserSearchKeywordPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, UserSearchKeywordPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchKeywordPageUI.SEARCH_BUTTON);
	}

	public boolean isSearchLengthTermDisplayed() {
		waitForElementVisible(driver, UserSearchKeywordPageUI.SEARCH_TERM_LENGTH_MESSAGE);
		return isElementDisplayed(driver, UserSearchKeywordPageUI.SEARCH_TERM_LENGTH_MESSAGE);
	}

	public boolean isMessageNoProductFound() {
		waitForElementVisible(driver, UserSearchKeywordPageUI.MESSAGE_NO_PRODUCT_FOUND);
		return isElementDisplayed(driver, UserSearchKeywordPageUI.MESSAGE_NO_PRODUCT_FOUND);
	} 
	

	public boolean isResultMatched(String keyword) {
		boolean pass = true;
		List<WebElement> listTitle = getElements(driver, UserSearchKeywordPageUI.LIST_PRODUCT_TITLE);

		for (WebElement webElement : listTitle) {

			if (webElement.getText().toLowerCase().contains(keyword)) {
				pass = true;
			} else {
				pass = false;
			}
		}
		return pass;
		
	}

	public int isNumberOfResultTrue() {
		List<WebElement> listTitle = getElements(driver, UserSearchKeywordPageUI.LIST_PRODUCT_TITLE);
		return listTitle.size();
		
	}

	public void clickToAdvancedSearchCheckbox() {
		waitForElementClickable(driver, UserSearchKeywordPageUI.ADVANCED_SEARCH_CHECKBOX);
		clickToElementByJS(driver, UserSearchKeywordPageUI.ADVANCED_SEARCH_CHECKBOX);
		sleepInSecond(1);
	}

	public void selectCategoryDropdownlistByValue(String textValue) {
		waitForElementVisible(driver, UserSearchKeywordPageUI.CATEGORY_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, UserSearchKeywordPageUI.CATEGORY_DROPDOWN_LIST, textValue);
		sleepInSecond(1);
	}

	public void clickToSubCategoryCheckbox() {
		waitForElementClickable(driver, UserSearchKeywordPageUI.SUB_CATEGORY_CHECKBOX);
		clickToElement(driver, UserSearchKeywordPageUI.SUB_CATEGORY_CHECKBOX);
		
	}

	public void selectSubCategoryDropdownlistByValue(String textValue) {
		waitForElementVisible(driver, UserSearchKeywordPageUI.SUB_CATEGORY_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, UserSearchKeywordPageUI.SUB_CATEGORY_DROPDOWN_LIST, textValue);
		sleepInSecond(1);
	}

}
