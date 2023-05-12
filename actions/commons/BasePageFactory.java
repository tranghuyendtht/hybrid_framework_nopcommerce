package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	
	private long longTime = 30;
	
	// Hàm khởi tạo
	public static BasePageFactory getBasePageObject() {
		return new BasePageFactory();
	}
	
	// Chứa các hàm dùng chung cho Page Object
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitForAlertPresence (WebDriver driver) {
		WebDriverWait explictitWait = new WebDriverWait(driver, longTime);
		return explictitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert (WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelAlert (WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getTextAlert (WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendkeyToAlert (WebDriver driver, String textAlert) {
		 waitForAlertPresence(driver).sendKeys(textAlert);
	}
	
	public String getWindowHandle (WebDriver driver) {
		 return driver.getWindowHandle();
	}
	
	public void switchWindowById (WebDriver driver, String windowId) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {
			if(!id.equals(allWindowIds)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	public void switchWindowByTitle (WebDriver driver, String tabTile) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if(actualTitle.equals(tabTile)) {
				break;
			}
		}
	}
	
	public void closeAllTabsWithoutParent (WebDriver driver, String parentID) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {
			
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}
	
	private WebElement getElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator));
	}
	
	private List<WebElement> getElements(WebDriver driver, String xpathLocator) {
		return driver.findElements(By.xpath(xpathLocator));
	}
	
	private By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		WebElement element = getElement(driver,xpathLocator);
		 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].click();", element);
	}
	
	public void sendkeyToElement (WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}
	
	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	public void selectItemInDefaultDropDown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getElement(driver, xpathLocator));
		select.selectByVisibleText(textItem);
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getElement(driver, xpathLocator));
		return select.isMultiple();
	}
	
	public String getSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time*1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getElementAtribute(WebDriver driver, String xpathLocator, String attributeName) {
		return getElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	public String getElementCssValue (WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).getCssValue(xpathLocator);
	}
	
	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize (WebDriver driver, String xpathLocator) {
		return getElements(driver, xpathLocator).size();
	}
	
	public void checkToCheckboxORRadio (WebDriver driver, String xpathLocator) {
		WebElement element = getElement(driver, xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToCheckbox (WebDriver driver, String xpathLocator) {
		WebElement element = getElement(driver, xpathLocator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean isElementIsEnable(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isEnabled();
	}
	
	public boolean isElementIsSelected(WebDriver driver, String xpathLocator) {
		return getElement(driver, xpathLocator).isSelected();
	}
	
	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getElement(driver, xpathLocator));
	}
	
	public void switchToDefaultContent(WebDriver driver, String xpathLocator) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement (WebDriver driver, String xpathLocator) {
		Actions action = new Actions (driver);
		action.moveToElement(getElement(driver, xpathLocator));
	}
	

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}


	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor  jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor	jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor 	jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible (WebDriver driver,WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		 explicitWait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void waitForAllElementVisible (WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		 explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
		
	}
	
	public void waitForElementInvisible (WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		 explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		
	}
	
	public void waitForAllElementInvisible (WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		 explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, locator)));
		
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTime);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	

}
