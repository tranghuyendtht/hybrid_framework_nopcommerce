package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageUIs.nopcommerce.user.UserProductListUI;
import commons.BasePage;
import commons.BasePageFactory;

public class ProductListPageFactory extends BasePageFactory {

	private WebDriver driver;

	
	// UI
	@FindBy(xpath = "//h2[@class='title']//a[text()=' Desktops ']")
	private WebElement desktopLink;
	@FindBy(xpath = "//a[text()='Build your own computer']")
	private WebElement aNameProductLink;
	
	// Action
	public ProductListPageFactory(WebDriver mappingDriver) {
		driver = mappingDriver;
		PageFactory.initElements(driver, this);
	}

	public void clickToDesktopLink() {
		waitForElementClickable(driver, desktopLink);
		clickToElement(driver, desktopLink);
	}

	public void clickToAProduct() {
		waitForElementClickable(driver, aNameProductLink);
		clickToElement(driver, aNameProductLink);

	}


}
