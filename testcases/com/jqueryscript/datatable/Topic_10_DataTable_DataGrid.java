package com.jqueryscript.datatable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.JQuery.Datatable.HomePageObject;
import pageObject.JQuery.Datatable.PageGeneratorManager;

public class Topic_10_DataTable_DataGrid extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllValueOnPage;
	List<String> ExpectAllValueOnPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

//@Test
	public void TC_01_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		homePage.openPagingByPageNumber("5");
		Assert.assertTrue(homePage.isPageNumberActived("5"));
		homePage.openPagingByPageNumber("3");
		Assert.assertTrue(homePage.isPageNumberActived("3"));
		homePage.openPagingByPageNumber("9");
		Assert.assertTrue(homePage.isPageNumberActived("9"));
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));

	}

//	@Test
	public void TC_02_Search_In_Header() {
		homePage.refreshPage(driver);

		homePage.enterToHeaderTextboxByTitle("Females", "276880");
		homePage.sleepInSecond(1);
		homePage.enterToHeaderTextboxByTitle("Country", "Angola");
		homePage.sleepInSecond(1);
		homePage.enterToHeaderTextboxByTitle("Males", "276472");
		homePage.sleepInSecond(1);
		homePage.enterToHeaderTextboxByTitle("Total", "553353");
		homePage.sleepInSecond(1);

	}

	@Test
	public void TC_03_Get_All_Value_In_Table() {
		// Actual Value
		actualAllValueOnPage = homePage.getValueEachRowAtAllPage();
		
		// Assert.assertEquals(actualAllValueOnPage, ExpectAllValueOnPage);
	}
	@Test
	public void TC_03_Get_Value_In_Column_By_Title_Name_Header() {
		// Actual Value
		//homePage.getValueEachRowAtAllPage();
		homePage.getValueColumnByTitleName("females");
		homePage.getValueColumnByTitleName("country");
		homePage.getValueColumnByTitleName("males");
		homePage.getValueColumnByTitleName("total");

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
