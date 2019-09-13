package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	
	public LoginPageTest() {
		super();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void homePageTest(){
		extentTest = extent.startTest("homePageTest");
		loginPage.clickOnSBS();
	}

}
