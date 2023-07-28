package pageObjects.nopcommerce.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.collect.Ordering;

import PageUIs.nopcommerce.user.UserComputerProductPageUI;
import PageUIs.nopcommerce.user.UserHomePageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserComputerProductPageObject extends BasePage{
	private WebDriver driver;
	
	public UserComputerProductPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void selectProductSortOrderByName(String textValue) {
		waitForElementVisible(driver, UserComputerProductPageUI.SORT_ORDER_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, UserComputerProductPageUI.SORT_ORDER_DROPDOWN_LIST, textValue);
		sleepInSecond(5);
		
	}

	public boolean isProductNameSortedAToZ() {
		List<WebElement> listAllProductName = getElements(driver, UserComputerProductPageUI.PRODUCT_NAME_LIST);
		List<String> productNameTitle = new ArrayList<String>();
		
		for (WebElement eachProductName : listAllProductName) {
			productNameTitle.add(eachProductName.getText());
		}
		boolean sorted = Ordering.natural().isOrdered(productNameTitle);
		return sorted;
	}
	
	public boolean isProductNameSortedZToA() {
		List<WebElement> listAllProductName = getElements(driver, UserComputerProductPageUI.PRODUCT_NAME_LIST);
		List<String> productNameTitle = new ArrayList<String>();
		
		for (WebElement eachProductName : listAllProductName) {
			productNameTitle.add(eachProductName.getText());
		}
		boolean sorted = Ordering.natural().reverse().isOrdered(productNameTitle);
		return sorted;
	}

	public void clickToSubMenuLinkTextOnHeaderMenuByText(String childTitleName) {
		waitForElementClickable(driver, UserHomePageUI.SUB_MENU_LINKTEXT,childTitleName);
		clickToElement(driver, UserHomePageUI.SUB_MENU_LINKTEXT,childTitleName);
		sleepInSecond(3);
	}

	public boolean isProductNameSortedLowToHighPrice() {
		List<WebElement> listAllProductPrice = getElements(driver, UserComputerProductPageUI.PRODUCT_PRICE_LIST);
		List<Integer> productPrice = new ArrayList<Integer>();
		
		for (WebElement eachProductPrice : listAllProductPrice) {
			int price = Integer.valueOf(eachProductPrice.getText().replaceAll("[^A-Za-z0-9]","")) ;
			productPrice.add(price);
		}
		boolean sorted = Ordering.natural().isOrdered(productPrice);
		return sorted;
		
	}

	public boolean isProductNameSortedHighToLowPrice() {
		List<WebElement> listAllProductPrice = getElements(driver, UserComputerProductPageUI.PRODUCT_PRICE_LIST);
		List<Integer> productPrice = new ArrayList<Integer>();
		
		for (WebElement eachProductPrice : listAllProductPrice) {
			int price = Integer.valueOf(eachProductPrice.getText().replaceAll("[^A-Za-z0-9]","")) ;
			productPrice.add(price);
		}
		boolean sorted = Ordering.natural().reverse().isOrdered(productPrice);
		return sorted;
		
	}

	public void selectProductPageSizeWithRecordNumber(String numberOfRecord) {
		waitForElementVisible(driver, UserComputerProductPageUI.PRODUCT_PAGE_SIZE);
		selectItemInDefaultDropDown(driver, UserComputerProductPageUI.PRODUCT_PAGE_SIZE, numberOfRecord);
		sleepInSecond(5);
		
	}
}
