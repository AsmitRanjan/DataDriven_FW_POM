package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.GenericFunction;

public class LoginPage extends GenericFunction{
	
	//Page Factory - OR:
	@FindBy(xpath="//a[contains(text(),'FLIGHTS')]")
	public WebElement btnFlights;
	
	public LoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	//Actions:	
	public void clickOnSBS() {
		ClickElement(btnFlights, "Flights");
		
	}	

}
