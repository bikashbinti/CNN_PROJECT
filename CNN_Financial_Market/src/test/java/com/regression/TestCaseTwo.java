package com.regression;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.masterpagefactory.MasterPageFactory;

import com.utill.ExplicitWait;
import com.utill.HighLighter;
import com.utill.TakeAppScreenShot;


public class TestCaseTwo {
	public static void getTitle(WebDriver driver) {

		MasterPageFactory pf = PageFactory.initElements(driver, MasterPageFactory.class);
		
			String TitleBeforeClick=driver.getTitle();
			ExplicitWait.getMyWait(driver, pf.getAllPageName().get(0));
			for (int i = 0; i < pf.getAllPageName().size(); i++) {

				while (true) {// never stop===> infinite time

					if (pf.getAllPageName().size()> 0) {
						HighLighter.getColor(driver, pf.getAllPageName().get(i), "green");
						String pageName = pf.getAllPageName().get(i).getText();
						ExplicitWait.getMyWait(driver, pf.getAllPageName().get(i));
						pf.getAllPageName().get(i).click();// ...............................................................Click
						System.out.println("Click here.............");
						
						// wait...............for market
						
						System.out.println("Home title ="+TitleBeforeClick +"=== After Click title "+driver.getTitle() );
						if (driver.getTitle() != null
								&& !driver.getTitle().contains(TitleBeforeClick)) {
							for (AllMyPageTitle myEnum : AllMyPageTitle.values()) {
								if (pageName.toUpperCase().contains(myEnum.toString())) {
									System.out.println("Found my Title = " + driver.getTitle());
									TakeAppScreenShot.captureScreenShot(driver, pageName);
									Assert.assertEquals(driver.getTitle(), myEnum.getTitle());
								}
							}
							break;// break the while loop
						}else {
							
							try {
								System.out.println("Need to wait...............");
								Thread.sleep(3000);
							} catch (InterruptedException e) {
							
							};
						} 
						
					}
					
				}

				if (i == 0) {
					driver.get("https://www.cnn.com/BUSINESS");

				}

			}

		}

	
}
