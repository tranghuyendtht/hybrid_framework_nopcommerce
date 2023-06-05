package com.jqueryscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUIs.jQuery.uploadFile.HomePageUI;
import commons.BaseTest;
import pageObjects.JQuery.UploadFile.HomePageObject;
import pageObjects.JQuery.UploadFile.PageGeneratorManager;

public class Topic_11_UploadFile extends BaseTest {
	HomePageObject homePage;
	WebDriver driver;
	String fileName_1 = "Dress_1.jpg";
	String fileName_2 = "Dress_2.jpg";
	String fileName_3 = "Dress_3.jpg";
	String[] multipleFileNames = { "Dress_1.jpg", "Dress_2.jpg", "Dress_3.jpg" };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Upload_One_File_Per_Times() {

		// Step 1: Upload single file
		homePage.uploadFiles(driver, fileName_1);

		// Step 2: Verify file is loaded
		Assert.assertTrue(homePage.isFileLoadedByName(fileName_1));

		// Step 3: Click to start button
		homePage.clickToStartButton();

		// Step 4: Verify file is uploaded successfully
		Assert.assertTrue(homePage.isFileUploadedByName(fileName_1));

		// Step 5: Verify image is upload successfully
		Assert.assertTrue(homePage.isImageUploadedByName(fileName_1));
	}

	@Test
	public void TC_02_Upload_Multiple_File_Per_Times() {
		homePage.refreshPage(driver);
		// Step 1: Upload multiple files
		homePage.uploadFiles(driver, multipleFileNames);

		// Step 2: Verify multiple file are loaded
		Assert.assertTrue(homePage.isFileLoadedByName(fileName_1));
		Assert.assertTrue(homePage.isFileLoadedByName(fileName_2));
		Assert.assertTrue(homePage.isFileLoadedByName(fileName_3));

		// Step 3: Click to start button
		homePage.clickToStartButton();

		// Step 4: Verify multiple files are uploaded successfully
		Assert.assertTrue(homePage.isFileUploadedByName(fileName_1));
		Assert.assertTrue(homePage.isFileUploadedByName(fileName_2));
		Assert.assertTrue(homePage.isFileUploadedByName(fileName_3));
		
		// Step 5: Verify multiple images are upload successfully
		Assert.assertTrue(homePage.isImageUploadedByName(fileName_1));
		Assert.assertTrue(homePage.isImageUploadedByName(fileName_2));
		Assert.assertTrue(homePage.isImageUploadedByName(fileName_3));
	}

	@AfterClass
	public void afterClass() {

	}
}
