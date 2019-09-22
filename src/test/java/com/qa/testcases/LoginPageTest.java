package com.qa.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import static com.qa.util.MYExtentReport.reports;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	TestBase driverfact=new TestBase();
	WebDriver driver = null;
	WebDriver webdriver = null;
	public LoginPageTest() {
		super();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void homePageTest(){
		ExtentTest test=null;
		test = reports.createTest("testAccounts");
        test.assignCategory("Smoke");
        driver=driverfact.getEventDriver(driver, test);
		extentTest = extent.startTest("homePageTest");
		loginPage.clickOnSBS();
	}

}
