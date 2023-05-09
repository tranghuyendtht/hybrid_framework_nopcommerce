package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.ProductListUI;
import commons.BasePage;

public class ProductListPageObject extends BasePage {

	private WebDriver driver;

	public ProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToDesktopLink() {
		waitForElementClickable(driver, ProductListUI.DESKTOP_LINK);
		clickToElement(driver, ProductListUI.DESKTOP_LINK);
	}

	public void clickToAProduct() {
		waitForElementClickable(driver, ProductListUI.A_NAME_PRODUCT_LINK);
		clickToElement(driver, ProductListUI.A_NAME_PRODUCT_LINK);

	}


}
