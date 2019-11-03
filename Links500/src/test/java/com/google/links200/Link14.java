package com.google.links200;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.excelreader.ExcelReader;
import com.google.objectreader.ObjectReader;
import com.google.utility.Utility;

public class Link14 {
	ExcelReader e;ObjectReader o;WebDriver links;
	@BeforeTest
	public void setUP() {
		e=new ExcelReader("./ExcelRepository/PopularLinksList.xlsx");
		o=new ObjectReader();
		System.setProperty("webdriver.chrome.driver", o.chromePath());
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		links=new ChromeDriver(options);
		links.manage().window().maximize();	
	}
	@Test
	public void navigateURL() {
		Utility.wait_Statement(3000);
		links.get(e.getExcelData(0, 14, 1));
		Utility.wait_Statement(3000);
	    Utility.screenShots(links, "14.link14-Homepage");
	}
	@AfterMethod
	public void tearDown(ITestResult fail) {
	if(ITestResult.FAILURE==fail.getStatus()) {
		Utility.screenShots(links, fail.getName());
	}
	}
	@AfterTest
	public void CloseBrowser() throws Exception{
	Thread.sleep(3000);	
	links.quit();	
	}

}
