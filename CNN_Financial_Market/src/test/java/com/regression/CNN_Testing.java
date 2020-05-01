package com.regression;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.excel.ExcelWriter;
import com.excel.ExcelRead;
import com.masterpagefactory.MasterPageFactory;

public class CNN_Testing {
	//private static final String dependsOnMethods = null;
	//static WebDriver driver;
	WebDriver driver;
	List<String> actualdata = new ArrayList<>();
	List<String> expectedValue = new ArrayList<>();

	@BeforeTest
	public void setup() {

		driver = TestCaseOne.setup();// return driver

	}

	@Test
	public void pagetitle_02() {
		TestCaseTwo.getTitle(driver);
	}

	@Test(dependsOnMethods="pagetitle_02")
	public void Market_03() {
		TestCaseThree.getMarketData(driver, actualdata);

	}

	@Test(dependsOnMethods = { "Market_03" })
	public void Market_04() {
		expectedValue = ExcelRead.returnExcel("./Test Data/Test Data Financial.xlsx", "Most Popular Stocks");
		System.out.println("Expected value from Test data excelvalue = " + expectedValue);
	}

	@Test(dependsOnMethods = { "Market_04" })
	public void Market_05() {

		new ExcelWriter().wtireExcelListCNN("./Test Data/CNNExcelWrite.xlsx", actualdata);

	}

	@Test(dependsOnMethods = { "Market_05" })
	public void Market_06() {

		Assert.assertEquals(actualdata, expectedValue,
				"Actual Value =" + actualdata + "......should  match withExpected Value = " + expectedValue);

	}

	@AfterTest
	public void teardown() {

		driver.quit();
	}

}
