package com.regression;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.masterpagefactory.MasterPageFactory;
import com.utill.ExplicitWait;
import com.utill.HighLighter;

public class TestCaseThree {
	
	
	public static void getMarketData(WebDriver driver,List<String> actualdata ) {

		MasterPageFactory pf = PageFactory.initElements(driver, MasterPageFactory.class);
		
		pf.getAllPageName().get(0).click();
		System.out.println("I am in Market page");
		ExplicitWait.getMyWait(driver, pf.getMostPopularStock().get(0));
		
		pf.getMostPopularStock().stream().forEach(data->{
			
			HighLighter.getColor(driver, data, pf.getMostPopularStock().indexOf(data));
			actualdata.add(data.getText().replace("\n", ","));// 2) add method ==>inside loop
		});
		System.out.println("Actual Application Value =" + actualdata);// 3) out side the loop
	
}
	
	
	
	
	
	
	

}
